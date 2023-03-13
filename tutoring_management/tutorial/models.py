
from django.db import models
from django.utils.translation import gettext_lazy as _
from tutorial_calification.models import StudentCalification, TutorCalification
from tutorial_request.models import Tutorial_Request

class State_Scale(models.IntegerChoices):
    RATED = 0, _('Sin calificar')
    NOT_RATED = 1, _('Calificada')
    
class Tutorial(models.Model):
    """
    Esta clase representa el objeto tutoria que se encarga de 
    crear las propiedades en la base de datos
    """
    tutorial_request = models.OneToOneField(Tutorial_Request, on_delete=models.CASCADE )
    date = models.DateField(max_length=10,blank=False, null=False)
    start_time = models.TimeField(blank=False, null=False)
    topics_covered = models.TextField(max_length=150, blank=False, null=False)
    tutor_calification = models.OneToOneField(TutorCalification,  on_delete=models.CASCADE)
    student_calification = models.OneToOneField(StudentCalification, on_delete=models.CASCADE, null= True)
    state = models.IntegerField(null=False, blank=False, default=0, choices=State_Scale.choices)

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase Tutorial
        """
        verbose_name = "Tutoría"
        verbose_name_plural = "Tutorías"

    def __str__(self):
        """
        Al llamar alguna instancia de la clase Tutorial retorna como String, 
        para hacer más reconocible el objeto.
        """
        return "{} - {} {} - {}".format(self.date, self.tutorial_request.tutor.first_name, self.tutorial_request.tutor.last_name , self.tutorial_request.subject.name)
         
    