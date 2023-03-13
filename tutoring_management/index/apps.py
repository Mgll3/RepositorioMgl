from django.apps import AppConfig


class IndexConfig(AppConfig):
    """
    Se encarga de administrar la metainformación del modulo index
    """
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'index'
    verbose_name = "Inicio"