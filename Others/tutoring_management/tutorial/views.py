from django.shortcuts import render, redirect
from tutorial_request.models import Tutorial_Request
from .forms import *
from tutorial_calification.forms import TutorCalificationForm
from django.contrib.auth.decorators import login_required
from django.core.mail import EmailMessage
from django.contrib import messages
from django.views.generic import TemplateView
from base.abstract_classes import Template_Method

class Tutorial_Registration_View(TemplateView, Template_Method):
    template_name = 'tutorial/tutorial_registration.html'

    def get(self, request):
        if request.user.role == "STUDENT":
            return redirect('index')
        return self._get(request, TutorialForm(user=request.user.id), TutorCalificationForm())
        
    def post(self, request):
        return self._post(request, TutorialForm(request.POST, user=request.user.id), TutorCalificationForm(request.POST))

    def form_validation(self, tutorial_form, tutor_form):
        return tutorial_form.is_valid() and tutor_form.is_valid()

    def save_object(self, request, tutor_form, tutorial_form):
            tutor_calification = tutor_form.save(commit=False)
            tutorial = tutorial_form.save(commit=False)
            tutorial.tutor_calification = tutor_calification
            tutor_calification.save()
            self.approve_tutorial_request(tutorial.tutorial_request)
            tutorial.save()
            messages.success(
                request, "Has registrado la tutoría correctamente.")

    def error_message(self, request):
        messages.warning(request, "Ha ocurrido un error")

    def _get(self, request, form_, form__):
        return render(request, self.template_name, {'tutorial_form':form_, 'tutor_calification_form':form__})

    def _post(self, request, tutorial_form, tutor_form):
        if self.form_validation(tutorial_form, tutor_form):
            self.save_object(request, tutor_form, tutorial_form)
        else:
            self.error_message(request)
        return render(request, self.template_name, {'tutorial_form':tutorial_form,'tutor_calification_form':tutor_form}) 

    def approve_tutorial_request(self, tutorial_request: Tutorial_Request):
        request = Tutorial_Request.objects.get(pk=tutorial_request.id)
        request.state = 3
        request.save()
