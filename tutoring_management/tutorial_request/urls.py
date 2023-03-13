from django.urls import path
from . import views
from django.contrib.auth.decorators import login_required

urlpatterns = [ 
    path('', login_required(views.TutorialRequestView.as_view()), name="tutorial_request"),
    path('my_requests/', login_required(views.TutorialResponseView.as_view()), name="tutorial_response"),
    path('my_requests/response/', login_required(views.TutorResponseView.as_view()), name="tutor_response"),
    path('my_request/approve/<int:pk>', login_required(views.approve_request), name="approve_tutorial_request"),
    path('my_request/reject/<int:pk>', login_required(views.reject_request), name="reject_tutorial_request"),

]