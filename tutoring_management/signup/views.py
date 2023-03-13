from django.shortcuts import redirect, render
from django.contrib.auth.decorators import login_required
from django.contrib.auth import login,authenticate
from .forms import LoginForm, StudentCreationForm
from django.contrib import messages

from django.views.generic import TemplateView
from base.abstract_classes import Template_Method

class Login_View(TemplateView, Template_Method):
    """
    Crea el formulario LoginForm y lo envía como contexto a la vista. 
    Se encarga de hacer las comprobaciones para luego corroborar en la base de datos la existencia del 
    usuario y si el este ingresa correctamente sus datos de acceso, lo loguea y le permite hacer uso
    de las funcionalidades del sistema. 
    """
    template_name = 'signup/login.html'

    def get(self, request):
        if request.user.is_authenticated:
            return redirect ('index')
        return self._get(request, LoginForm())

    def post(self, request):
        return self.post_(request, LoginForm(request.POST))

    def form_validation(self, form):
        return form.is_valid()

    def save_object(self, request, form):
        _username = form.cleaned_data.get('username')
        _password = form.cleaned_data.get('password')
        user = authenticate(request, username= _username, password= _password)
        if user is not None:
            login(request, user)
            return redirect('index')
        else:
            messages.info(request, "Usuario y/o contraseña incorrectos")
            return redirect("login")

    def error_message(self, request):
        messages.warning(request, "Ha ocurrido un error")
    

class Signup_View(TemplateView, Template_Method):  
    """
    Crea el formulario StudentCreationForm y lo envía como contexto a la vista.
    Se encarga de hacer las comprobaciones para luego guardar en la base de datos 
    la información digitada por el usuario en el formulario.
    """  
    template_name = 'signup/student_register.html'

    def get(self, request):
        if request.user.is_authenticated:
            return redirect ('index')
        return self._get(request, StudentCreationForm())

    def post(self, request):
        return self._post_(request, StudentCreationForm(request.POST), StudentCreationForm())

    def form_validation(self, form):
        return form.is_valid()

    def save_object(self, request, form):
        student = form.save(commit=False)
        email = form.cleaned_data.get('email')
        validation = email.find('@udea.edu.co')
        student.username = email[0:validation]
        student.save()
        messages.success(request, "¡Registro completado, procede a iniciar sesión!")
        

    def error_message(self, request):
        messages.warning(request, "Revisa los campos y llénalos adecuadamente")




























from .forms import TutorCreationForm
class SignupTutor_View(TemplateView, Template_Method):  
    """
    Crea el formulario StudentCreationForm y lo envía como contexto a la vista.
    Se encarga de hacer las comprobaciones para luego guardar en la base de datos 
    la información digitada por el usuario en el formulario.
    """  
    template_name = 'signup/tutor_register.html'

    def get(self, request):
        if request.user.is_authenticated:
            return redirect ('index')
        return self._get(request, TutorCreationForm())

    def post(self, request):
        self.post_(request, TutorCreationForm(request.POST))
        return redirect("index")

    def form_validation(self, form):
        return form.is_valid()

    def save_object(self, request, form):
        student = form.save(commit=False)
        email = form.cleaned_data.get('email')
        validation = email.find('@udea.edu.co')
        student.username = email[0:validation]
        student.save()
        return redirect("login")

    def error_message(self, request):
        messages.warning(request, "Ha ocurrido un error")