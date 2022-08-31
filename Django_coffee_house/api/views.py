from unicodedata import name
from rest_framework.decorators import api_view
from rest_framework.response import Response
from .serializers import coffeeSerializer
from .models import Coffee

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


@api_view(['GET'])
def getCoffees(request):
    #получение всего списка кофе 
    coffees=Coffee.objects.all()
    # преабразуемы данные, many=True получение всех данных 
    serializar=coffeeSerializer(coffees, many=True)
    return Response(serializar.data)

@api_view(['GET'])
def getCoffee(request, pk):
    #получение конкретный элемент
    coffee=Coffee.objects.get(id=pk)
    # преабразуемы данные, many=False получение один элемент 
    serializar=coffeeSerializer(coffee, many=False)
    return Response(serializar.data)

# создание записи
@api_view(['POST'])
def createCoffee(request ):
    # данные которые вернёт сервер 
    data = request.data
    coffee = Coffee.objects.create(
        name=data['name'],
        description=data['description'],
        price=data['price'],
        volume=data['volume'],
        available_toppings=data['available_toppings']
    )

    serializer= coffeeSerializer(coffee, many=False)
    return Response(serializer.data)

# обновление записи
@api_view(['PUT'])
def updateCoffee(request, pk):
    # данные которые вернёт сервер 
    data = request.data

    coffee = Coffee.objects.get(id=pk)

    serializer= coffeeSerializer(coffee, data=request.data)
    if serializer.is_valid():
        serializer.save()

    return Response(serializer.data)

# удаление записи
@api_view(['DELETE'])
def deleteCoffee(request, pk):
    coffee = Coffee.objects.get(id=pk)
    coffee.delete()
    return Response("Удаление прошло успешно")