from django.urls import path
from . import views
from django.contrib.auth.decorators import login_required

"""
Genera la conexión entre el controlador y la ruta 
"""
urlpatterns = [ 
    path('', login_required(views.CalificationView.as_view()), name="calification"),
]