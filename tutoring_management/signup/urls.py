from . import views
from django.urls import path, include


urlpatterns = [
    path('accounts/', include('django.contrib.auth.urls')),
    path('login/', views.Login_View.as_view(), name="login"),
    path('signup/', views.Signup_View.as_view(), name="student_registration"),
    path('signups/', views.SignupTutor_View.as_view(), name="tutor_registration"),
]
