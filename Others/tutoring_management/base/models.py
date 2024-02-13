from django.db import models

# Create your models here.
class Academic_Program(models.Model):
    """
    Esta clase representa el objeto Academic_Program que se encarga de 
    crear las propiedades de cada programa academico en la base de datos
    """
    modality = models.CharField(max_length=30, null=False, blank=False)
    name = models.CharField(max_length=100, null=False, blank=False)
    program_code = models.IntegerField(null=False, blank=False)

    class Meta:
        verbose_name = "Programa académico"
        verbose_name_plural = "Programas académicos"

    def __str__(self):
        return self.name



