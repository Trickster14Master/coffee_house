from dataclasses import field
from rest_framework.serializers import ModelSerializer
from rest_framework import serializers
from .models import Coffee, Dessert, Order, User, Topping
# сериализация данных кофе
class coffeeSerializer(ModelSerializer):
    class Meta:
        model= Coffee
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
    sum_table = serializers
    class Meta:
        model= Order
        fields=('userToken','date','coffee','topping','dessert','sum_table',)