from django.apps import AppConfig

class TutorialConfig(AppConfig):
    """"
    Representa la metadata del módulo de las tutorias
    """
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'tutorial'
    verbose_name = "Tutoría"
    