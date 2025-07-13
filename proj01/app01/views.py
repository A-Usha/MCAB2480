from django.shortcuts import render

# Create your views here.
from django.shortcuts import render
from django.views.generic.edit import CreateView
from django.views.generic import ListView
from django.views.generic.edit import UpdateView
from django.views.generic.edit import DeleteView
from django.urls import reverse_lazy
from .models import Student

class StudentCreateView(CreateView):
    model = Student
    fields = ['name', 'roll_number', 'course', 'enrollment_date']
    template_name = 'student_form.html'
    success_url = reverse_lazy('student_list')

class StudentListView(ListView):
    model = Student
    context_object_name = 'students'
    template_name = 'student_list.html'

class StudentUpdateView(UpdateView):
    model = Student
    fields = ['name', 'roll_number', 'course', 'enrollment_date']
    template_name = 'student_form.html'
    success_url = reverse_lazy('student_list')

class StudentDeleteView(DeleteView):
    model = Student
    template_name = 'student_confirm_delete.html'
    success_url = reverse_lazy('student_list')