from django.urls import path
from . import views
urlpatterns = [
   path('home/',views.home, name='home'),
   path('master/',views.master, name='master'),
	]
