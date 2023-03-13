from abc import ABC, abstractmethod
from django.shortcuts import render

class Template_Method(ABC):
    template_name = ""

    def _get(self, request, form):
        form_ = form
        return render(request, self.template_name, {'form':form_})

    def _post(self, request, form):
        form_ = form
        if self.form_validation(form_):
            self.save_object(request, form_)
        else:
            self.error_message(request)
        return render(request, self.template_name, {'form':form_}) 

    @abstractmethod
    def form_validation(self, form):
        pass

    @abstractmethod
    def save_object(self, request, form):
        pass
    
    @abstractmethod
    def error_message(self, request):
        pass

    def post_(self, request, form):
        form_ = form
        if self.form_validation(form_):
            return self.save_object(request, form_)
            
        else:
            self.error_message(request)
        return render(request, self.template_name, {'form':form_}) 

    def _post_(self, request, form, form__):
        form_ = form
        if self.form_validation(form_):
            self.save_object(request, form_)
        else:
            self.error_message(request)
            return render(request, self.template_name, {'form':form_})
        return render(request, self.template_name, {'form':form__}) 

class State(ABC):
    @abstractmethod
    def change_state(self, *args):
        pass
