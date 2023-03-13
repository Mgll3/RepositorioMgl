from django.apps import AppConfig

class TutorialCalificationConfig(AppConfig):
    """"
    Representa la metadata del módulo de tutorial_calification
    """
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'tutorial_calification'
    verbose_name = "Calificación de tutoría"