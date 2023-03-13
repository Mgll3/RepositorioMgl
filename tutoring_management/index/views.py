from django.shortcuts import render
#from base.models import Academic_Program

def index(request):
    """
    Redirige a la vista del Inicio de la Aplicación
    """
    return render(request, "index/index.html")

def contact(request):
    """
    Redirige a la vista del Inicio/contacto de la Aplicación
    """
    return render(request, "index/contact.html" )