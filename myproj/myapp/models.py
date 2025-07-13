from django.db import models

# Create your models here.
class Faculty(models.Model):
    name = models.CharField(max_length=100)
    department = models.CharField(max_length=100)
    joining_date = models.DateField()

    def __str__(self):
        return self.name