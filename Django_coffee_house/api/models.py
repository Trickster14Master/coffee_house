from django.db import models

def upload_to(instance, filename):
    return 'posts/{filename}'.format(filename=filename)

class Coffee (models.Model):
    name = models.TextField(null=True)
    description= models.TextField(null=True)
    price = models.IntegerField(null=True)
    volume= models.IntegerField(null=True)
    urlsImage=models.ImageField(upload_to=upload_to)

    class Meta:
        ordering = ['name']

    def __str__(self):
        return self.name[0:50]


class Dessert (models.Model):
    name = models.TextField(null=True)
    price = models.IntegerField(null=True)
    urlsImage=models.ImageField(upload_to=upload_to)

    class Meta:
        ordering = ['name']
    
    def __str__(self):
        return self.name[0:50]

class User (models.Model):
    userName = models.TextField(null=True)
    userPassword= models.TextField(null=True)


        
    def __str__(self):
        return self.userName[0:50]

class Topping (models.Model):
    Name = models.TextField(null=True)
    price = models.IntegerField(null=True)
    volume = models.IntegerField(null=True)
    urlsImage=models.ImageField(upload_to=upload_to, default = "")



    def __str__(self):
        return self.Name[0:50]
    
class Product (models.Model):
    name = models.TextField(null=True)
    description= models.TextField(null=True)
    type = models.TextField(null=True)
    price = models.IntegerField(null=True)
    volume= models.IntegerField(null=True)
    urlsImage=models.ImageField(upload_to=upload_to)
    urlsIcon=models.ImageField(upload_to=upload_to)

    class Meta:
        ordering = ['name']

    def __str__(self):
        return self.name[0:50]
    
class Order (models.Model):
    userToken = models.TextField(default="")
    date= models.DateTimeField(auto_now_add=True)
    product = models.ManyToManyField(Product)
    # coffee = models.ManyToManyField(Coffee)
    # topping = models.ManyToManyField(Topping)
    # dessert = models.ManyToManyField(Dessert)
    # total_cost = models.IntegerField(default=0)
    # @property
    # def sum_table(self):
    #     return self.coffee.price + self.topping.price + self.topping.price
    