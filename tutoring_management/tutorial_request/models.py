from django.db import models
from signup.models import Student, Tutor
from index.models import Subject
from django.utils.translation import gettext_lazy as _
from base.interfaces import Observer, Observable


class State_Scale(models.IntegerChoices):
    WAITING = 0, _('Espera')
    APROVED = 1, _('Aprobada')
    REJECTED = 2, _('Rechazada')
    FINISHED = 3, _('Registrada')

class Tutorial_Request(models.Model):

    state = models.IntegerField(null=False, blank=False, default=0, choices=State_Scale.choices)
    student = models.ForeignKey(Student, blank=False, null=False, on_delete=models.CASCADE)
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)
    tutor = models.ForeignKey(Tutor, blank=False, null=False, on_delete=models.CASCADE)
    topics = models.CharField(max_length=200, blank=False, null=False)
    date_created = models.DateField(auto_now_add=True)

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase Tutorial
        """
        verbose_name = "Solicitud de tutoría"
        verbose_name_plural = "Solicitudes de tutorías"

    def __str__(self):
        return "{} {} - {} - {}".format(self.student.first_name,self.student.last_name,self.subject.name, self.date_created)
    
    def notify(self): #CAMBIAR ESTO
        Student.send_email()
        Tutor.send_email()
        try:
            if not self.changed: return
            localArray = self.obs[:]
            self.clearChanged()
        finally:
            self.mutex.release()
        for observer in localArray:
            observer.send_email()
            