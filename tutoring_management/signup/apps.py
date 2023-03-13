from django.apps import AppConfig


class SignupConfig(AppConfig):
    """
    Se encarga de administrar la metainformación del modulo signup
    """
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'signup'
    verbose_name = "Usuarios"
