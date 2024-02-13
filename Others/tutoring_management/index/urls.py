from django.urls import path
from . import views
"""
Genera la conexión entre el controlador y la ruta 
"""

urlpatterns = [ 
    path('', views.index, name="index"),
    path('contact/', views.contact, name="contact"),
]