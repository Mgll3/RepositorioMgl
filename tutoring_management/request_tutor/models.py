from django.db import models
from index.models import Subject
from .validators import validate_file_extension
from signup.models import Student
from django.utils.translation import gettext_lazy as _

class Request_State(models.IntegerChoices):
    """
    Esta clase representa el estado de una tutoría a través de un listado de opciones
    """
    WAITING = 0, _('Espera')
    APROVED = 1, _('Aprobado')
    REJECTED = 2, _('Rechazado')


class Request_to_tutor(models.Model):
    """
    Esta clase representa el objeto Request_to_tutor que se encarga de 
    crear las propiedades en la base de datos
    """

    day = models.CharField(max_length=50)
    time = models.CharField(max_length=20, default = '')
    student = models.ForeignKey(Student, on_delete=models.CASCADE)
    SEA = models.BooleanField(default=False)
    need_hours = models.BooleanField(default=False)
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE, default=1)
    date = models.DateField(auto_now_add=True)
    response_date = models.DateField(auto_now_add=True) 
    certificate = models.FileField(validators=[validate_file_extension], default="", upload_to='certifications/')
    request_state = models.CharField(max_length=15,choices=Request_State.choices, default=Request_State.WAITING)

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase Tutorial
        """
        verbose_name = "Solicitud para ser tutor"
        verbose_name_plural = "Solicitudes para ser tutor"

    def __str__(self):
        return self.student.first_name + " " + self.student.first_name + " - " + self.subject.name
    