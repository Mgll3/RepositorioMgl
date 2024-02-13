from django.contrib import admin
from .models import Administrative, Tutor, Student

class AdministrativeAdmin(admin.ModelAdmin):
    list_display = ("first_name",)
    
admin.site.register(Administrative,AdministrativeAdmin)
# Register your models here.

class StudentAdmin(admin.ModelAdmin):
    list_display = ("first_name","last_name","academic_program","semester","email",)
    
admin.site.register(Student,StudentAdmin)

class TutorAdmin(admin.ModelAdmin):
    list_display = ("first_name","last_name","academic_program","semester","email",)
admin.site.register(Tutor,TutorAdmin)