from django.contrib import admin
from .models import Academic_Program



class Academic_ProgramAdmin(admin.ModelAdmin):
    list_display=("name","program_code","modality",)
    
admin.site.register(Academic_Program, Academic_ProgramAdmin)
