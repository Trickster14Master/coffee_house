from dataclasses import field
from rest_framework.serializers import ModelSerializer
from .models import Coffee

# сериализация данных 
class coffeeSerializer(ModelSerializer):
    class Meta:
        model= Coffee
        fields='__all__'