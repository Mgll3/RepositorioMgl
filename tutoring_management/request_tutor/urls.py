from django.urls import path
from . import views

"""
Genera la conexión entre el controlador y la ruta 
"""
urlpatterns = [ 
    path('', views.RequestToBeTutor_View.as_view(), name="be_a_tutor"),
]