from . import views
from django.urls import path

urlpatterns = [
    path('', views.getRoutes),
    # url по которому обращаться и вызываемая функция 
    path('coffees/', views.getCoffees),
    path('coffee/create/', views.createCoffee),
    path('coffee/<str:pk>/update/', views.updateCoffee),
    path('coffee/<str:pk>/delete/', views.deleteCoffee),
    path('coffee/<str:pk>/', views.getCoffee),

]