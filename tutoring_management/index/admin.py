from django.contrib import admin
from .models import Subject
class SubjectAdmin(admin.ModelAdmin):
    list_display=("name","academic_program",) 
    list_filter = ("academic_program",)
admin.site.register(Subject, SubjectAdmin)