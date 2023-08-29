from rest_framework.decorators import api_view
from rest_framework import viewsets
from rest_framework.response import Response
from rest_framework.permissions import *
from rest_framework.authentication import TokenAuthentication
from api.permissions import IsAdminOrReadOnly
from .serializers import *
from .models import Coffee, Order, Product
from django_filters.rest_framework import DjangoFilterBackend
from rest_framework.filters import SearchFilter

# маршруты которые будут использоваться 
@api_view(['GET'])
def getRoutes(request):
    routes = [
        {
            'Endpoint':'/notes/',
            'method':'GET',
            'body': None,
            'description':'description I"m too lazy to invent'
        },{
            'Endpoint':'/notes/id',
            'method':'GET',
            'body':None,
            'description':'description I"m too lazy to invent'
        },{
            'Endpoint':'/notes/create/',
            'method':'POST',
            'body':{'body':""},
            'description':'description I"m too lazy to invent'
        },{
            'Endpoint':'/notes/id/update',
            'method':'PUT',
            'body':{'body':""},
            'description':'description I"m too lazy to invent'
        },{
            'Endpoint':'/notes/id/delete/',
            'method':'DELETE',
            'body':None,
            'description':'description I"m too lazy to invent'
        },
    ]
    # возвращаем данные в формате json 
    return Response(routes)


class ProductAPI(viewsets.ModelViewSet):
    queryset= Product.objects.all()
    serializer_class= productSerializer 
    authentication_classes=(TokenAuthentication,)
    filter_backends = (DjangoFilterBackend, SearchFilter)
    search_fields = ['type']
    
class OrderAPI(viewsets.ModelViewSet):
    queryset= Order.objects.all()
    serializer_class = orderSerializer 
    filter_backends = (DjangoFilterBackend, SearchFilter)
    search_fields = ['userToken']

class PostOrderAPI(viewsets.ModelViewSet):
    queryset= Order.objects.all()
    serializer_class= postOrderSerializer 
    # права в зависимости от пользователя 
    #permission_classes=(IsAdminOrReadOnly,)
    # в зависимости от того естли токен будет выдан доступ 








class CoffeeAPI(viewsets.ModelViewSet):
    queryset= Coffee.objects.all()
    serializer_class= coffeeSerializer 
    # права в зависимости от пользователя 
    # permission_classes=(IsAdminOrReadOnly,)
    # в зависимости от того естли токен будет выдан доступ 
    authentication_classes=(TokenAuthentication,)
class DessertAPI(viewsets.ModelViewSet):
    queryset= Dessert.objects.all()
    serializer_class= dessertSerializer 
    permission_classes=(IsAdminOrReadOnly,)
    
class UserAPI(viewsets.ModelViewSet):
    queryset= User.objects.all()
    serializer_class= userSerializer 
    #permission_classes=(IsAdminOrReadOnly,)
    
class ToppingAPI(viewsets.ModelViewSet):
    queryset= Topping.objects.all()
    serializer_class= toppingSerializer 
    permission_classes=(IsAdminOrReadOnly,)

# @api_view(['GET'])
# def getCoffees(request):
#     #получение всего списка кофе 
#     coffees=Coffee.objects.all()
#     # преабразуемы данные, many=True получение всех данных 
#     serializar=coffeeSerializer(coffees, many=True)
#     return Response(serializar.data)

# @api_view(['GET'])
# def getCoffee(request, pk):
#     #получение конкретный элемент
#     coffee=Coffee.objects.get(id=pk)
#     # преабразуемы данные, many=False получение один элемент 
#     serializar=coffeeSerializer(coffee, many=False)
#     return Response(serializar.data)

# # создание записи
# @api_view(['POST'])
# def createCoffee(request ):
#     # данные которые вернёт сервер 
#     data = request.data
#     coffee = Coffee.objects.create(
#         name=data['name'],
#         description=data['description'],
#         price=data['price'],
#         volume=data['volume'],
#         available_toppings=data['available_toppings']
#     )

#     serializer= coffeeSerializer(coffee, many=False)
#     return Response(serializer.data)

# # обновление записи
# @api_view(['PUT'])
# def updateCoffee(request, pk):
#     # данные которые вернёт сервер 
#     data = request.data

#     coffee = Coffee.objects.get(id=pk)

#     serializer= coffeeSerializer(coffee, data=request.data)
#     if serializer.is_valid():
#         serializer.save()

#     return Response(serializer.data)

# # удаление записи
# @api_view(['DELETE'])
# def deleteCoffee(request, pk):
#     coffee = Coffee.objects.get(id=pk)
#     coffee.delete()
#     return Response("Удаление прошло успешно")    
