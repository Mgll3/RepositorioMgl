from django.forms import ModelForm, Textarea, ValidationError, Select
from tutorial_request.models import Tutorial_Request
from .models import Tutorial
from django.utils.translation import gettext_lazy as _
from .widget import DatePickerInput, TimePickerInput, DateTimePickerInput

class TutorialForm(ModelForm):
    """
    Esta clase crea la base del formulario con las propiedades de la clase Tutorial
    y le da una capa de presentacion al formulario
    """
    class Meta:
        model = Tutorial
        fields = '__all__'
        exclude = ('tutor_calification','student_calification','state')
        widgets = {
            'tutorial_request': Select(attrs={'class':'form-select form-control-all'}),
            'date' : DatePickerInput(attrs={'class':'form-control form-control-all'}),
            'start_time' : TimePickerInput(attrs={'class':'form-control form-control-all'}),
            'topics_covered': Textarea(attrs={'class':'form-control form-control-all','placeholder':'Escribe los temas abordados en la tutoría realizada'}),
            }
        labels = {
            'tutorial_request': _('Solicitud'),
            'start_time': _('Hora de Inicio:'),
            'topics_covered': _('Temas Abordados:'),
            'date': _('Fecha:'),
            }

    def __init__(self, *args, **kwargs):
        user = kwargs.pop('user', None)
        super().__init__(*args, **kwargs)
        self.fields['tutorial_request'].queryset = Tutorial_Request.objects.filter(state=1, tutor_id=user)
