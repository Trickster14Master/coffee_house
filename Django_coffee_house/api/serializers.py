from dataclasses import field
from rest_framework.serializers import ModelSerializer
from rest_framework import serializers
from .models import Coffee, Dessert, Order, User, Topping,Product

# сериализация данных кофе
class coffeeSerializer(ModelSerializer):
    class Meta:
        model= Coffee
        fields='__all__'

class productSerializer(ModelSerializer):
    class Meta:
        model= Product
        fields='__all__'

# сериализация данных кофе
class toppingSerializer(ModelSerializer):
    class Meta:
        model= Topping
        fields='__all__'

class dessertSerializer(ModelSerializer):
    class Meta:
        model= Dessert
        fields='__all__'
        
class userSerializer(ModelSerializer):
    class Meta:
        model= User
        fields='__all__'
        
class orderSerializer(ModelSerializer):
    product = productSerializer(read_only=True, many=True)
    # coffee = coffeeSerializer(read_only=True, many=True)
    # topping = toppingSerializer(read_only=True, many=True)
    # dessert = dessertSerializer(read_only=True, many=True)
    class Meta:
        model= Order
        fields=('userToken','date','product','price')

class postOrderSerializer(ModelSerializer):
    class Meta:
        model= Order
        fields='__all__'
