from tkinter.tix import CheckList
from django import forms
from .models import Request_to_tutor
from django.utils.translation import gettext_lazy as _
from django.forms import CheckboxInput, CheckboxSelectMultiple, FileInput, ModelForm, MultipleChoiceField, Select, ValidationError, TextInput, MultipleChoiceField, SelectMultiple
from .widget import DatePickerInput, TimePickerInput, DateTimePickerInput


class Request_to_tutorForm(ModelForm):
    """
    Esta clase crea la base del formulario con las propiedades de la clase Request_to_tutor
    y le da una capa de presentacion al formulario
    """
    class Meta:
        model = Request_to_tutor
        fields = '__all__'
        exclude = ('student','request_state')
        widgets = {
            'day': TextInput(attrs={'class': 'form-control form-control-all'}),
            'time': TextInput(attrs={'class': 'form-control form-control-all'}),
            'certificate': FileInput(attrs={'class': 'form-control form-control-all'}),
            'modality': Select(attrs={'class': 'form-select form-control-all'}),
            'subject': Select(attrs={'class': 'form-select form-control-all'}),
            'SEA': CheckboxInput(attrs={'class': 'form-check-input mt-0 '}),
            'need_hours': CheckboxInput(attrs={'class': 'form-check-input mt-0 '}),
        }

        labels = {
            'day': _('Días disponibles'),
            'time': _('Horas de disponibilidad'),
            'certificate': _('Certificado (archivos .png, .jpg o .pdf)'),
            'modality': _('Modalidad'),
            'subject': _('Materia'),
            'SEA': _('¿Pertenece al SEA?'),
            'need_hours': _('¿Necesita horas de labor social?'),
        }
