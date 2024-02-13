from django.forms import ModelForm, TextInput, Select, Textarea
from django import forms
from tutorial.models import Tutorial
from .models import StudentCalification, TutorCalification
from django.utils.translation import gettext_lazy as _

class StudentCalificationForm(ModelForm):
    """
    Esta clase crea la base del formulario con las propiedades de la clase StudentCalification
    y le da una capa de presentacion al formulario
    """
    tutorial = forms.ModelChoiceField(widget=forms.Select(attrs={'class':'form-select form-control-all'}),label="Selecciona la tutoría que deseas calificar",queryset=Tutorial.objects.filter(state=0))
    class Meta:
        model = StudentCalification
        fields = '__all__'
        labels = {
            'grade':_('Calificación'),
            'feedback':_("Retroalimentación"),
            'tutor_behavior':_("¿Cómo se comportó el tutor?"),
            'how_know':_("¿Cómo te enteraste de las tutorías?")
            }
        widgets = {
            'grade': Select(attrs={'class':'form-select form-control-all'}),
            'feedback': Textarea(attrs={'class':'form-control form-control-all', 'placeholder':'Escribe tus comentarios acerca de la tutoría recibida'}),
            'tutor_behavior': Select(attrs={'class':'form-select form-control-all'}),
            'how_know': Select(attrs={'class':'form-select form-control-all'}),
        }

    field_order = ['tutorial', 'grade','feedback','tutor_behavior','how_know']
    
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        #self.fields['tutorial'].queryset = Tutorial.objects.filter(state=0)


class TutorCalificationForm(ModelForm):
    """
    Esta clase crea la base del formulario con las propiedades de la clase TutorCalificationForm
    y le da una capa de presentacion al formulario
    """
    class Meta:
        model = TutorCalification
        fields = '__all__'
        
        widgets = {}
        labels = {
            'grade':_('¿Cómo te sentiste dando la tutoría?'),
            'feedback':_("Cuéntanos tu experiencia"),
            }

        widgets = {
            'grade': Select(attrs={'class':'form-select form-control-all'}),
            'feedback': Textarea(attrs={'class':'form-control form-control-all','placeholder':'Escribe tus comentarios acerca de la tutoría dada'}),
        }
