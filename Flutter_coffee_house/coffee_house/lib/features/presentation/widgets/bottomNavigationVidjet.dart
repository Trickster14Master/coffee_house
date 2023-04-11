import 'package:flutter/material.dart';

class BottomNavigationWidget extends StatefulWidget {
  BottomNavigationWidget({Key? key}) : super(key: key);

  @override
  State<BottomNavigationWidget> createState() => _BottomNavigationWidgetState();
}

class _BottomNavigationWidgetState extends State<BottomNavigationWidget> {
  int _selectedPage = 1;
  // функция которая отвечает за то какая страница будет выбрана
  void onSelectPage(int index) {
    if (_selectedPage == index) return;
    setState(() {
      _selectedPage = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return BottomNavigationBar(
      onTap: onSelectPage,
      currentIndex: _selectedPage,
      // ignore: prefer_const_literals_to_create_immutables
      items: [
        const BottomNavigationBarItem(
            icon: Icon(
              Icons.add_location_sharp,
            ),
            label: "кофейни"),
        const BottomNavigationBarItem(
            icon: Icon(
              Icons.coffee,
            ),
            label: "ассортимент"),
        const BottomNavigationBarItem(
          icon: Icon(
            Icons.person,
          ),
          label: "информация о пользователе",
        )
      ],
    );
  }
}
