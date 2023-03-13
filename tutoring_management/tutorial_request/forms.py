from django import forms
from django.forms import ModelForm, Select, Textarea
from .models import Tutorial_Request
from django.utils.translation import gettext_lazy as _
from tutorial.widget import DatePickerInput, TimePickerInput

class Tutorial_Request_Form(ModelForm):
    class Meta:
        model = Tutorial_Request
        fields = '__all__'
        exclude = ('state', 'date_created', 'student')
        widgets = {
            'subject': Select(attrs={'class':'form-select form-control-all'}),
            'tutor':   Select(attrs={'class':'form-select form-control-all'}),
            'topics': Textarea(attrs={'class':'form-control form-control-all','placeholder':'Escribe los temas a repasar y los horarios en los que te encuentras disponibles..'}),
        }
        labels = {
            'topics': _("Temas Para Abordar"),
            'tutor': _("Tutores Disponibles"),
            'subject': _("Materia"),
            
        }
class Tutorial_Response_Form(ModelForm):
    class Meta:
        model = Tutorial_Request
        fields = '__all__'
        exclude = ('state', 'date_created', 'student')
        widgets = {
            'subject': Select(attrs={'class':'form-select form-control-all'}),
            'tutor':   Select(attrs={'class':'form-select form-control-all'}),
            'topics': Textarea(attrs={'class':'form-control form-control-all','placeholder':'Escribe los temas a repasar y los horarios en los que te encuentras disponibles..'}),
        }
        labels = {
            'topics': _("Respuesta Tutoría"),
            'tutor': _("Tutores Disponibles"),
            'subject': _("Materia"),
            
        }

class Tutor_Response_Form(forms.Form):
    date = forms.CharField(label="Fecha", widget=DatePickerInput(attrs={'class':'form-control form-control-all','placeholder':'Fecha en la que vas a dar tutoría'} ))
    hour = forms.CharField(label="Hora", widget=TimePickerInput(attrs={'class':'form-control form-control-all','placeholder':'Escribe la hora de encuentro'}))
    place = forms.CharField(label="Lugar", widget=forms.TextInput(attrs={'class':'form-control form-control-all','placeholder':'Lugar donde vas a dar la tutoría'} ))
