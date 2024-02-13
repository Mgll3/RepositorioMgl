from django.forms import EmailInput, PasswordInput, CheckboxInput, NumberInput, Select, TextInput, ValidationError
from .models import Student, Tutor
from django.utils.translation import gettext_lazy as _
from django import forms
from django.contrib.auth.forms import UserCreationForm


class LoginForm(forms.Form):
    """
    Esta clase crea la base del formulario con las propiedades de la clase Usuario
    y le da una capa de presentacion al formulario.
    """
    username = forms.CharField(
        label="Usuario",
        max_length=30,
        widget = forms.TextInput(attrs={'class': 'form-control form-control-all'}))
    password = forms.CharField(
        label="Contraseña",
        max_length=20,
        widget=PasswordInput(attrs={'class': 'form-control form-control-all'}))

class StudentCreationForm(UserCreationForm):
    """
    Esta clase crea la base del formulario con las propiedades de la clase Student
    y le da una capa de presentacion al formulario
    """
    first_name= forms.CharField(label='Nombre',widget=forms.TextInput(attrs={'class':'form-control form-control-all'}))
    last_name= forms.CharField(label='Apellido',widget=forms.TextInput(attrs={'class':'form-control form-control-all'}))
    password1 = forms.CharField(label='Contraseña',widget=forms.PasswordInput(attrs={'class': 'form-control form-control-all'}) )
    password2 = forms.CharField(label='Confirmar Contraseña',widget=forms.PasswordInput(attrs={'class': 'form-control form-control-all'}))

    class Meta:
        """
        Esta subclase se encarga de darle las mejoras visuales a los campos del formulario
        """
        model = Student
        fields = ['first_name','last_name','id_student','semester','academic_program','email']
        exclude = ('role','base_role')
        widgets = {
            'id_student': NumberInput(attrs={'class':'form-control form-control-all'}),
            'email': EmailInput(attrs={'class':'form-control form-control-all','aria-describedby':'emailHelp'}),
            'semester':  Select(attrs={'class':'form-select form-control-all'}),
            'academic_program':  Select(attrs={'class':'form-select form-control-all'}),
            }

        labels = {
            'id_student': _('Número de Identificación'),
            'email': _('Correo Institucional'),
            'semester': _('Semestre Académico'),
            'academic_program':_('Programa académico'),
            }

    def clean_email(self):
        """ 
        Se encarga de verificar si el dato ingresado en 'email' 
        contiene la cadena '@udea.edu.co', de no estarlo arrojará un error
        al usuario.
        """
        email = self.cleaned_data.get('email')
        validation = email.find('@udea.edu.co')
        if validation == -1:
            raise ValidationError("Tu correo no pertenece a la UdeA.")
        elif validation < 4:
            raise ValidationError("Tu correo es muy corto.")
        else:
            return email


# FALTA
class StudentModificationForm(forms.ModelForm):
    first_name= forms.CharField(label='Nombre',widget=forms.TextInput(attrs={'class':'form-control form-control-all'}))
    last_name= forms.CharField(label='Apellido',widget=forms.TextInput(attrs={'class':'form-control form-control-all'}))
    #password1 = forms.CharField(label='Contraseña',widget=forms.PasswordInput(attrs={'class': 'form-control form-control-all'}) )
    #password2 = forms.CharField(label='Confirmar Contraseña',widget=forms.PasswordInput(attrs={'class': 'form-control form-control-all'}))
    
    class Meta:
        model = Student
        fields = ['first_name','last_name','semester','academic_program']
        widgets = {
            'semester':  Select(attrs={'class':'form-select form-control-all'}),
            'academic_program':  Select(attrs={'class':'form-select form-control-all'}),
            }
        labels = {
            'semester': _('Semestre Académico'),
            'academic_program':_('Programa académico'),
            }
    
class TutorModificationForm(UserCreationForm):

    class Meta:
        model = Tutor
        fields = ['SEA','need_hours','schedule']
        widgets = {
            'SEA':  CheckboxInput(attrs={'class':'form-check-input form-control-all'}),
            'need_hours':  CheckboxInput(attrs={'class':'form-check-input form-control-all'}),
            'schedule':  TextInput(attrs={'class':'form-input form-control-all'}),
            }
            
        labels = {
            'SEA':_('¿Perteneces al SEA?'),
            'need_hours': _('¿Necesita horas?'),
            'schedule':_('Horario'),
            }


    





































class TutorCreationForm(UserCreationForm):
    """
    Esta clase crea la base del formulario con las propiedades de la clase Student
    y le da una capa de presentacion al formulario
    """
    first_name= forms.CharField(label='Nombre',widget=forms.TextInput(attrs={'class':'form-control form-control-all'}))
    last_name= forms.CharField(label='Apellido',widget=forms.TextInput(attrs={'class':'form-control form-control-all'}))
    password1 = forms.CharField(label='Contraseña',widget=forms.PasswordInput(attrs={'class': 'form-control form-control-all'}) )
    password2 = forms.CharField(label='Confirmar Contraseña',widget=forms.PasswordInput(attrs={'class': 'form-control form-control-all'}))

    class Meta:
        """
        Esta subclase se encarga de darle las mejoras visuales a los campos del formulario
        """
        model = Tutor
        fields = ['first_name','last_name','id_student','semester','academic_program','email', 'schedule', 'SEA', 'need_hours']
        exclude = ('role','base_role')
        widgets = {
            'id_student': NumberInput(attrs={'class':'form-control form-control-all'}),
            'email': EmailInput(attrs={'class':'form-control form-control-all','aria-describedby':'emailHelp'}),
            'semester':  Select(attrs={'class':'form-select form-control-all'}),
            'academic_program':  Select(attrs={'class':'form-select form-control-all'}),
            }

        labels = {
            'id_student': _('Número de Identificación'),
            'email': _('Correo Institucional'),
            'semester': _('Semestre Académico'),
            'academic_program':_('Programa académico'),
            }

    def clean_email(self):
        """ 
        Se encarga de verificar si el dato ingresado en 'email' 
        contiene la cadena '@udea.edu.co', de no estarlo arrojará un error
        al usuario.
        """
        email = self.cleaned_data.get('email')
        validation = email.find('@udea.edu.co')
        if validation == -1:
            raise ValidationError("Tu correo no pertenece a la UdeA.")
        elif validation < 4:
            raise ValidationError("Tu correo es muy corto.")
        else:
            return email

