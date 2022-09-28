from django.contrib import admin

# Register your models here.
from .models import Coffee
admin.site.register(Coffee)

from .models import Topping
admin.site.register(Topping)

from .models import User
admin.site.register(User)

from .models import Order
admin.site.register(Order)

from .models import Dessert
admin.site.register(Dessert)