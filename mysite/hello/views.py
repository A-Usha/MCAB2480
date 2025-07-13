from django.shortcuts import render
#Create your view here.
from django.http import HttpResponse
from django.template import loader


def demo(request):
  temp = loader.get_template('ultag04.html')
  return HttpResponse(temp.render())



