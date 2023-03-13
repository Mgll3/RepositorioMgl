from django.db import models
from base.models import Academic_Program
from signup.models import Tutor
# Create your models here.
class Subject(models.Model):
    """
    Esta clase representa el objeto Subject que se encarga de 
    crear las propiedades de cada materia en la base de datos
    """
    name = models.CharField(null=False, blank=False, max_length=100)
    academic_program = models.ForeignKey(Academic_Program, on_delete=models.CASCADE)
    tutors = models.ManyToManyField(Tutor)  

    class Meta:
        verbose_name = "Materia"
        verbose_name_plural = "Materias"

    def __str__(self):
        return self.name