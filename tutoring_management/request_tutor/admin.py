from django.contrib import admin
from request_tutor.models import Request_to_tutor

class RequestTutorAdmin(admin.ModelAdmin):
    list_display = ("student","subject","request_state",)
admin.site.register(Request_to_tutor, RequestTutorAdmin)