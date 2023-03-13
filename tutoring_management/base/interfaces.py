from abc import abstractmethod
from abc import ABCMeta


class Request_State(metaclass = ABCMeta):
    @abstractmethod
    def approve_request(self):
        pass
    
    @abstractmethod
    def reject_request(self):
        pass

class Aplicar_Estado_Solicitud(metaclass = ABCMeta):
    @abstractmethod
    def create_tutor(self):
        pass


class Observer(metaclass = ABCMeta):
    @abstractmethod
    def send_email(*args):
        pass
    
class Observable(metaclass = ABCMeta):
    @abstractmethod
    def notify():
        pass
    
    
