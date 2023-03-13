from django.contrib import admin
from .models import Tutorial_Request

class TutorialRequestAdmin(admin.ModelAdmin):
    list_display = ("id","student", "subject","tutor","state","date_created")    #Lista para mostrar info de los objetos
admin.site.register(Tutorial_Request, TutorialRequestAdmin)