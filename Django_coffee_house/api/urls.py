from . import views
from django.urls import path, include, re_path 
from rest_framework import routers

# кофе 
routerCoffee = routers.SimpleRouter()
routerCoffee.register(r'Coffee', views.CoffeeAPI)

# заказы 
routerOrder = routers.SimpleRouter()
routerOrder.register(r'Order', views.OrderAPI)

# топпинг 
routerTopping = routers.SimpleRouter()
routerTopping.register(r'Topping', views.ToppingAPI)

# пользователи 
routerUser = routers.SimpleRouter()
routerUser.register(r'User', views.UserAPI)

# десерты 
routerDessert = routers.SimpleRouter()
routerDessert.register(r'Dessert', views.DessertAPI)


urlpatterns = [
    path('', views.getRoutes),
    path("Coffee/", include(routerCoffee.urls)),
    path("Order/", include(routerOrder.urls)),
    path("Topping/", include(routerTopping.urls)),
    path("User/", include(routerUser.urls)),
    path("Dessert/", include(routerDessert.urls)),
    # url для авторизации (встроено)
    # path("avtor/", include('rest_framework.urls'))
    # url для авторизации (djoser)
    path('Coffee/auth/', include('djoser.urls')),
    re_path(r'^auth/', include('djoser.urls.authtoken')),
    


    # # url по которому обращаться и вызываемая функция 
    # path('coffees/', views.getCoffees),
    # path('coffee/create/', views.createCoffee),
    # path('coffee/<str:pk>/update/', views.updateCoffee),
    # path('coffee/<str:pk>/delete/', views.deleteCoffee),
    # path('coffee/<str:pk>/', views.getCoffee),

]