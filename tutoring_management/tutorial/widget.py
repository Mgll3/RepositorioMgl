from django import forms

"""
Estas clases representan unas herramientas que mejoran el estilo de algunos parámtetros del formulario.
"""
class DatePickerInput(forms.DateInput):
    input_type = 'date'

class TimePickerInput(forms.TimeInput):
     input_type = 'time'

class DateTimePickerInput(forms.DateTimeInput):
     input_type = 'datetime'