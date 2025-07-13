from django.views.generic import CreateView, ListView, UpdateView, DeleteView
from django.urls import reverse_lazy
from .models import Faculty

class FacultyCreateView(CreateView):
    model = Faculty
    fields = ['name', 'department', 'joining_date']
    template_name = 'faculty_form.html'
    success_url = reverse_lazy('faculty_list')

class FacultyListView(ListView):
    model = Faculty
    context_object_name = 'faculties'
    template_name = 'faculty_list.html'

class FacultyUpdateView(UpdateView):
    model = Faculty
    fields = ['name', 'department', 'joining_date']
    template_name = 'faculty_form.html'
    success_url = reverse_lazy('faculty_list')

class FacultyDeleteView(DeleteView):
    model = Faculty
    template_name = 'faculty_confirm_delete.html'
    success_url = reverse_lazy('faculty_list')