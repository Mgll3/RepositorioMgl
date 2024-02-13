from django.shortcuts import render, redirect
from .forms import *
from django.contrib import messages
from signup.models import Student
from django.views.generic import TemplateView
from base.abstract_classes import Template_Method
from base.concrete_classes import Approved_State, Rejected_State, Waiting_State
from .forms import Tutorial_Request_Form, Tutor_Response_Form, Tutorial_Request

class TutorialRequestView(TemplateView, Template_Method):
    template_name = 'tutorial_request/tutorial_request.html'

    def get(self, request):
        if request.user.role == "TUTOR":
            return redirect('index')
        return self._get(request, Tutorial_Request_Form())

    def post(self, request):
        return self._post(request, Tutorial_Request_Form(request.POST))

    def form_validation(self, form):
        return form.is_valid()

    def save_object(self, request, form):
        request_tutorial = form.save(commit=False)
        student = Student.objects.get(id=request.user.id)
        request_tutorial.student = student
        waiting = Waiting_State()
        waiting.send_email(request_tutorial)
        request_tutorial.save()
        messages.success(request, "Tu solicitud ha sido realizada con éxito")
    
    def error_message(self, request):
        messages.warning(request, "Ha ocurrido un error")


class TutorialResponseView(TemplateView):
    template_name = 'tutorial_request/tutorial_response.html'
    def get(self, request):
        if request.user.role == "STUDENT":
            return redirect('index')
        tutorial_requests = Tutorial_Request.objects.all().order_by('state').filter(tutor_id=request.user.id) #TODO
        return render (request, self.template_name, {'context': tutorial_requests})


id_tutorial = 0

class TutorResponseView(TemplateView, Template_Method):
    template_name = 'tutorial_request/tutor_response.html'
    
    def get(self, request):
        print(id_tutorial)
        return self._get(request, Tutor_Response_Form())

    def post(self, request):
       return self.post_(request, Tutor_Response_Form(request.POST))

    def form_validation(self, form):
        return form.is_valid()

    def save_object(self, request, prueba):
        date = request.POST['date']
        place = request.POST['place']
        hour = request.POST['hour']
        print(id_tutorial)
        tutorial_request = Tutorial_Request.objects.get(id = id_tutorial)
        approve = Approved_State()
        approve.send_email(tutorial_request, date, place, hour)
        return redirect("tutorial_response")

    def error_message(self, request):
        messages.warning(request, "Ha ocurrido un error")

def approve_request(request, pk):
    approve = Approved_State()
    approve.change_state(pk)
    global id_tutorial
    id_tutorial = pk
    return redirect('tutor_response')

def reject_request(request, pk):
    reject = Rejected_State()
    tutorial_request = reject.change_state(pk)
    reject.send_email(tutorial_request)
    return redirect('tutorial_response')
