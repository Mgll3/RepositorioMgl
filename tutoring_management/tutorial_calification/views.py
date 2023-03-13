from base.abstract_classes import Template_Method
from tutorial.models import Tutorial
from tutorial_calification.models import StudentCalification
from .forms import StudentCalificationForm
from django.contrib import messages
from django.views.generic import TemplateView
from django.shortcuts import redirect

class CalificationView(TemplateView, Template_Method):
    """
    Crea el formulario StudentCalificationForm y lo envía como contexto a la vista
    Se encarga de hacer las comprobaciones para luego guardar en la base de datos 
    la información digitada por el usuario en el formulario 
    """
    template_name = 'tutorial_calification/student_calification.html'

    def get(self, request):
        if request.user.role == "TUTOR":
            return redirect('index')
        return self._get(request, StudentCalificationForm())

    def post(self, request):
        return self._post(request, StudentCalificationForm(request.POST))

    def form_validation(self, form):
        return form.is_valid()

    def save_object(self, request, form):
        tutorial_id = request.POST['tutorial']
        calification = form.save()
        self.update_tutorial_calification(tutorial_id, calification)
        messages.success(request, "Has calificado tu tutoría")

    def error_message(self, request):
        messages.warning(request, "Ha ocurrido un error")


    def update_tutorial_calification(tutorial_id, calification):
        """
        Actualiza el valor de una tutoría, asignandole la calificación otorgada por un estudiante
        """
        tutorial = Tutorial.objects.get(pk=tutorial_id)
        tutorial.student_calification = StudentCalification.objects.get(pk=calification.id)
        tutorial.state = 1
        tutorial.save()
    