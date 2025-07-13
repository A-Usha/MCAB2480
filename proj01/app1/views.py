from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse
from django.template import loader
def home(request):
    temp=loader.get_template('home.html')
    return HttpResponse(temp.render())

def master(request):
    temp=loader.get_template('master.html')
    return HttpResponse(temp.render())