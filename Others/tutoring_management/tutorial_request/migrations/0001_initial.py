# Generated by Django 4.0.5 on 2022-11-16 02:35

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('signup', '0001_initial'),
        ('index', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Tutorial_Request',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('state', models.IntegerField(choices=[(0, 'Espera'), (1, 'Aprobado'), (2, 'Rechazado')], default=0)),
                ('topics', models.CharField(max_length=200)),
                ('date_created', models.DateField(auto_now_add=True)),
                ('student', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='signup.student')),
                ('subject', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='index.subject')),
                ('tutor', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='signup.tutor')),
            ],
            options={
                'verbose_name': 'Solicitud de tutoría',
                'verbose_name_plural': 'Solicitudes de tutorías',
            },
        ),
    ]