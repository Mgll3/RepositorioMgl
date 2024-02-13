from django.shortcuts import render, redirect
from django.contrib import messages
from signup.models import Student
from .forms import *
from django.contrib.auth.decorators import login_required
from base.abstract_classes import Template_Method
from django.views.generic import TemplateView

class RequestToBeTutor_View(TemplateView, Template_Method):
    """
    Crea el formulario Request_to_tutorForm y lo envía como contexto a la vista
    Se encarga de hacer las comprobaciones para luego guardar en la base de datos 
    la información digitada por el usuario en el formulario 
    """
    template_name = 'request_tutor/request_tutor.html'

    def get(self, request):
        return self._get(request, Request_to_tutorForm())

    def post(self, request):
        return self._post(request, Request_to_tutorForm(request.POST or None, request.FILES or None))

    def form_validation(self, form):
        return form.is_valid()

    def save_object(self, request, form):
        student = Student.objects.get(id=request.user.id)
        file = form.cleaned_data.get('certificate')
        obj = form.save(commit=False)
        obj.certificate = file
        obj.student = student
        obj.save()
        messages.success(request, "Tu solicitud ha sido enviada, pronto tendrás respuesta.")
    
    def error_message(self, request):
        messages.warning(request, "Ha ocurrido un error")
