from django.db import models
from django.contrib.auth.models import AbstractUser
from django.utils.translation import gettext_lazy as _
from base.models import Academic_Program
from base.interfaces import Observer
from django.core.mail import EmailMessage
from django.shortcuts import redirect

class User(AbstractUser):
    """
    Esta clase representa el objeto usuario, que se encarga de 
    crear las propiedades en la base de datos. User es el que 
    se encarga de crear los usuarios que podrán ingresar al sistema.
    """
    class Role(models.TextChoices):
        """
        Esta clase representa los roles de los usuarios a través de un listado de opciones.
        """
        ADMIN = "ADMINISTRATOR", 'Administrator'
        STUDENT = "STUDENT", 'Student'
        TUTOR = "TUTOR", 'Tutor'

    base_role = Role.STUDENT
    role = models.CharField(max_length=15, choices=Role.choices)
    email = models.EmailField(
        max_length=30, blank=False, null=False, unique=True)
    username = models.CharField(max_length=40, unique=True, default='')
    has_tutorial = models.BooleanField(blank=False, null= False, default = False)

    def save(self, *args, **kwargs):
        """
        Se encarga la creación de los User
        """
        if not self.pk:
            self.role = self.base_role
            return super().save(*args, **kwargs)

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase User
        """
        verbose_name = "Usuario"
        verbose_name_plural = "Usuarios"


class Semester_Scale(models.IntegerChoices):
    """
    Esta clase representa el listado de semestres disponibles.
    """
    ONE = 1, _('1')
    TWO = 2, _('2')
    THREE = 3, _('3')
    FOUR = 4, _('4')
    FIVE = 5, _('5')
    SIX = 6, _('6')
    SEVEN = 7, _('7')
    EIGTH = 8, _('8')
    NINE = 9, _('9')
    TEN = 10, _('10')
    __empty__ = _('Selecione su semestre actual')


class ActiveStudent(User):
    """
    Esta es una clase abstracta que hereda de la clase User, y representa a los estudiantes matriculados en la universidad
    """
    id_student = models.IntegerField(blank=False, null=False)
    semester = models.IntegerField(
        blank=False, null=False, choices=Semester_Scale.choices)
    academic_program = models.ForeignKey(
        Academic_Program, on_delete=models.CASCADE)
    
    
    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase User
        """
        abstract = True
        verbose_name = "Estudiante activo"
        verbose_name_plural = "Estudiantes activos"
    

class Tutor(ActiveStudent):
    """
    Esta es una clase abstracta que hereda de la clase User, y representa a los 
    tutores voluntarios.
    """
    base_role = User.Role.TUTOR
    schedule = models.CharField(
        max_length=150, default="", null=False, blank=False)
    SEA = models.BooleanField(default=False)
    need_hours = models.BooleanField(default=False)

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de 
        la clase Tutor
        """
        verbose_name = "Tutor"
        verbose_name_plural = "Tutores"

    def __str__(self):
        return self.first_name + " " + self.last_name

    def send_email(request_tutorial):
        """
        Envia un correo eléctronico al momento de hacer una solicitud de tutoría al correo electrónico del tutor
        al cual se le haya hecho la solicitud. 
        """
        try:
            student_name = request_tutorial.student.first_name + " " + request_tutorial.student.last_name
            student_email = request_tutorial.student.email
            subject_name = request_tutorial.subject.name
            tutor_name = request_tutorial.tutor.first_name
            tutor_email = request_tutorial.tutor.email
            email_subject = "Tienes una solicitud de tutoría nueva! \U0001F604 "
            message = '¡Hola, {}!\n\nEl estudiante {}({}) te ha solicitado una tutoría para la materia "{}" con los siguientes temas: \n "{}"'.format(
            tutor_name, student_name, student_email, subject_name, request_tutorial.topics)
            email_message = EmailMessage(email_subject, message, "", [
                                      tutor_email], reply_to=[student_email])
            email_message.send()
        except:
            return redirect('index')
    
class Student(ActiveStudent):
    """
    Esta es una clase abstracta que hereda de la clase User, y representa a los 
    estudiantes que piden tutorías en el sistema.
    """
    base_role = User.Role.STUDENT

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de 
        la clase Student
        """
        verbose_name = "Estudiante"
        verbose_name_plural = "Estudiantes"

    def __str__(self):
        return self.first_name + " " + self.last_name

    def send_email(request_tutorial):
        """
        Envia un correo eléctronico al momento de hacer una solicitud de tutoría al correo electrónico del tutor
        al cual se le haya hecho la solicitud. 
        """
        try:
            student_name = request_tutorial.student.first_name + " " + request_tutorial.student.last_name
            student_email = request_tutorial.student.email
            subject_name = request_tutorial.subject.name
            tutor_name = request_tutorial.tutor.first_name
            tutor_email = request_tutorial.tutor.email
            email_subject = "¡Realizaste una solicitud de tutoría nueva! \U0001F604 "
            message = '¡Hola, {}!\n\n Has solicitado una nueva tutoría para la materia "{}", en 48h tendrás una respuesta, en caso de no recibirla realiza una solicitud nueva!!'.format(
            student_name, subject_name)
            email_message = EmailMessage(email_subject, message, "", [
                                      tutor_email], reply_to=[student_email])
            email_message.send()
        except:
            return redirect('index')


class Administrative(User):
    """
    Esta es una clase abstracta que hereda de la clase User, y representa a los 
    administrativos (Personal de bienestar) que se encargan de gestionar la información recibida.
    """
    base_role = User.Role.ADMIN

    class Meta:
        """
        Esta subclase se encarga de la generación de la metainformación de la clase User
        """
        verbose_name = "Administrativo"
        verbose_name_plural = "Administrativos"
