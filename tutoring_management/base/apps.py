from django.apps import AppConfig


class BaseConfig(AppConfig):
    """
    Se encarga de administrar la metainformación del modulo base
    """
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'base'
