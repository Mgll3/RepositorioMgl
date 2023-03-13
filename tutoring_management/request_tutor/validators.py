from django.core.exceptions import ValidationError

def validate_file_extension(value):
    """
    Este método se encarga de verificar que un campo de tipo "File" sea de un tipo o formato especifico
    """
    if (not value.name.endswith('.pdf') and 
        not value.name.endswith('.jpg') and
        not value.name.endswith('.png')):
        raise ValidationError(u'Debe anexar un formato de archivo válido tales como pdf, jpg ó png')