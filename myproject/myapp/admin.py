from django.contrib import admin

# Register your models here.
from .models import Canteen, MenuItem

class MenuItemInline(admin.TabularInline):
    model = MenuItem
    extra = 1

class CanteenAdmin(admin.ModelAdmin):
    inlines = [MenuItemInline]
    list_display = ['name']

admin.site.register(Canteen, CanteenAdmin)
admin.site.register(MenuItem)