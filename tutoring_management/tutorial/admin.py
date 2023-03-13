from django.contrib import admin
from .models import *
# Register your models here.
class TutorialAdmin(admin.ModelAdmin):
    list_display = ("tutorial_request", "date","start_time","topics_covered","tutor_calification")  

admin.site.register(Tutorial, TutorialAdmin)



