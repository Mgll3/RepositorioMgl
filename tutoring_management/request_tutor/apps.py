from django.apps import AppConfig

class RequestTutorConfig(AppConfig):
    """
    Representa la metadata del módulo de request_tutor
    """
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'request_tutor'
    verbose_name = "Solicitud para ser tutor"
