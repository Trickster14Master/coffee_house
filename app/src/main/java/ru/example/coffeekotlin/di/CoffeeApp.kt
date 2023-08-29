package ru.example.coffeekotlin.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
// данный класс показывает библиотеке для инъекции и зависимости где взять контекст приложения
class CoffeeApp:Application()