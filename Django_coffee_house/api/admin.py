from django.contrib import admin

# Register your models here.
from .models import Coffee
admin.site.register(Coffee)


from .models import Topping
admin.site.register(Topping)