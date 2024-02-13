from django.contrib import admin
from django.urls import path, include

"""
Genera la conexión entre el aplicación y la ruta 
"""

urlpatterns = [
    path('admin/', admin.site.urls),
    path('tutorial/',include('tutorial.urls')),
    path('tutorial_request/',include('tutorial_request.urls')),
    path('',include('signup.urls')),
    path('calification/',include('tutorial_calification.urls')),
    path('be_tutor/',include('request_tutor.urls')),
    path('',include('index.urls')),
]