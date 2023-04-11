import 'package:flutter/material.dart';
import '../../../common/app_colors.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedPage = 1;

  static const List<Widget> _widgetOptions = <Widget>[
    Text(
      "A",
    ),
    Text(
      "B",
    ),
    Text(
      "C",
    )
  ];

  // функция которая отвечает за то какая страница будет выбрана
  void onSelectPage(int index) {
    if (_selectedPage == index) return;
    setState(() {
      _selectedPage = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: mainBackground,
      appBar: AppBar(
        title: const Text("коффейня "),
        backgroundColor: appBarBackground,
      ),
      body: Center(child: _widgetOptions[_selectedPage]),
      // ignore: prefer_const_literals_to_create_immutables
      bottomNavigationBar: BottomNavigationBar(
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
      ),
    );
  }
}
