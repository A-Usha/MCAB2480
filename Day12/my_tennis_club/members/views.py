from django.http import HttpResponse
from django.template import loader
from .models import Member
def members(request):
  #mydata = Member.objects.all()
  #mydata = Member.objects.values_list('firstname')

  context = {
    'mymembers': mydata,
  }
  template = loader.get_template('myfirst.html')
  return HttpResponse(template.render(context, request))
 