from django.db import models


class Coffee (models.Model):
    name = models.TextField(null=True)
    description= models.TextField(null=True)
    price = models.TextField(null=True)
    volume= models.IntegerField(null=True)
    available_toppings = models.ForeignKey("Topping", on_delete=models.PROTECT, null=True)

    def __str__(self):
        return self.name[0:50]

class Topping (models.Model):
    name = models.TextField(null=True)
    price = models.TextField(null=True)
    volume= models.IntegerField(null=True)

    def __str__(self):
        return self.name[0:50]