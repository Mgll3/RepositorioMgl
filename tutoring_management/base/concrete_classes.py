from django.core.mail import EmailMessage
from django.shortcuts import redirect
from base.abstract_classes import State
from tutorial_request.models import Tutorial_Request

class Approved_State(State):
    def change_state(self, tutorial_request_id):
        tutorial_request = Tutorial_Request.objects.get(pk=tutorial_request_id)
        tutorial_request.state = 1
        tutorial_request.save()
    
    def send_email(self, tutorial_request, date, place, hour):
        try:
            subject_name = tutorial_request.subject.name
            tutor = tutorial_request.tutor
            tutor_name = tutor.first_name + " " + tutor.last_name
            tutor_email = tutor.email
            student = tutorial_request.student
            student_name = student.first_name
            student_email = student.email
            email_subject = "¡Tu solicitud de tutoría ha sido Aprobada!"
            message = '¡Hola, {}!\nLa solicitud de tutoría para "{}" que has solicitado con el/la estudiante {}({}) ya ha sido programada. \U0001F600 \n\n Fecha: {} \n Hora: {} \n Lugar: {} \n\n Al finalizar la tutoría por favor califica la tutoría recibida!!'.format(
                 student_name, subject_name, tutor_name, tutor_email, date, hour, place)
            email_message = EmailMessage(email_subject, message, "", [
                student_email], reply_to=[tutor_email])
            email_message.send()
        except:
             return redirect('index')
        

class Rejected_State(State):
    def change_state(self, tutorial_request_id):
        tutorial_request = Tutorial_Request.objects.get(pk=tutorial_request_id)
        tutorial_request.state = 2
        tutorial_request.save()
        return tutorial_request
    
    def send_email(self,tutorial_request):
        try:
            subject_name = tutorial_request.subject.name
            tutor = tutorial_request.tutor
            tutor_name = tutor.first_name + " " + tutor.last_name
            tutor_email = tutor.email
            student = tutorial_request.student
            student_name = student.first_name
            student_email = student.email
            email_subject = "¡Tu solicitud de tutoría ha sido rechazada!"
            message = '¡Hola, {}!\nLa solicitud de tutoría para "{}" que has solicitado con el/la estudiante {}({}) ha sido rechazada. \U0001F62A \n ¡TE INVITAMOS A HACER UNA NUEVA SOLICITUD CON UN TUTOR DIFERENTE!'.format(
                 student_name, subject_name, tutor_name, tutor_email)
            email_message = EmailMessage(email_subject, message, "", [
                student_email], reply_to=[tutor_email])
            email_message.send()
        except:
             return redirect('index')
        
class Waiting_State(State):
    def change_state(self, tutorial_request_id):
        tutorial_request = Tutorial_Request.objects.get(pk=tutorial_request_id)
        tutorial_request.state = 0
        tutorial_request.save()

    def send_email(self,request_tutorial):
        try:
            student_name = request_tutorial.student.first_name + " " + request_tutorial.student.last_name
            student_email = request_tutorial.student.email
            subject_name = request_tutorial.subject.name
            tutor_name = request_tutorial.tutor.first_name
            tutor_email = request_tutorial.tutor.email
            email_subject = "Tienes una solicitud de tutoría nueva \U0001F604"
            message = '¡Hola, {}!\n\nEl estudiante {}({}) te ha solicitado una tutoría para la materia "{}" con los siguientes temas: \n "{}"'.format(
            tutor_name, student_name, student_email, subject_name, request_tutorial.topics)
            email_message = EmailMessage(email_subject, message, "", [
                                      tutor_email], reply_to=[student_email])
            email_message.send()
        except:
            return redirect('index')

class Finished_State(State):
    def change_state(self, tutorial_request_id):
        tutorial_request = Tutorial_Request.objects.get(pk=tutorial_request_id)
        tutorial_request.state = 0
        tutorial_request.save()

    def send_email(self,request_tutorial):
        try:
            student_name = request_tutorial.student.first_name + " " + request_tutorial.student.last_name
            student_email = request_tutorial.student.email
            subject_name = request_tutorial.subject.name
            tutor_name = request_tutorial.tutor.first_name
            tutor_email = request_tutorial.tutor.email
            email_subject = "Califica la tutoría recibida \U0001F604"
            message = '¡Hola, {}!\n\n Cuéntanos cómo fue tu experencia en la tutoria recibida por parte del tutor {}. \n\n Hasta pronto!! \U0001F609'.format(
            student_name, tutor_name)
            email_message = EmailMessage(email_subject, message, "", [
                                      tutor_email], reply_to=[student_email])
            email_message.send()
        except:
            return redirect('index')
      