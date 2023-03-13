from django.db import models
from django.utils.translation import gettext_lazy as _

class Grade_Scale(models.IntegerChoices):
    """
    Esta clase representa la escala de calificación con un listado de 1 a 5
    """
    ONE = 1,_('1')
    TWO = 2,_('2')
    THREE = 3,_('3')
    FOUR = 4,_('4')
    FIVE = 5,_('5')
    __empty__ = _('Califica del 1 al 5')
    

class Calification(models.Model):
    """
    Esta clase representa el objeto Calification que se encarga de 
    crear las propiedades en la base de datos
    """
    grade = models.IntegerField(null = False, blank = False, choices=Grade_Scale.choices)
    feedback = models.TextField(max_length=200, null = True, blank=True)

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase StudentCalification
        """
        abstract = True
        verbose_name = "Calificación de tutoría"
        verbose_name_plural = "Calificaciones de las tutorías"
    def __str__(self):
        return self.grade

class StudentCalification(Calification):
    """
    Esta clase representa la calificación del estudiante y esta hereda de la clase Calificaciton.
    """
    HOW_FIND_OUT_CHOICES = [
        ("SOCIAL_MEDIA","Redes sociales"),
        ("OFFICE","Oficina de bienestar 18-119a"),
        ("EMAIL","Correo electrónico"),
        ("WEB","Portal universitario"),
        ("OTHER","Otro"),
    ]

    tutor_behavior = models.IntegerField(null = False, blank = False, choices=Grade_Scale.choices, default=Grade_Scale.ONE)
    how_know = models.TextField(max_length=200, null = True, blank=True, choices=HOW_FIND_OUT_CHOICES, default="SOCIAL_MEDIA")

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase StudentCalification
        """
        verbose_name = "Calificación dada por el estudiante"
        verbose_name_plural = "Calificación dada por el estudiante"
    def __str__(self):
        return self.grade

class TutorCalification(Calification):
    """
    Esta clase representa la calificación del tutor y esta hereda de la clase Calificaciton.

    """
    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase TutorCalification
        """
        verbose_name = "Calificación de tutoría"
        verbose_name_plural = "Calificaciones de las tutorías"
    def __str__(self):
        return self.grade