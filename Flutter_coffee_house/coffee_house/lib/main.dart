import 'package:flutter/material.dart';

import 'common/app_colors.dart';
import 'features/presentation/pages/home_test.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
          backgroundColor: mainBackground,
          bottomNavigationBarTheme: const BottomNavigationBarThemeData(
              selectedItemColor: iconBackground,
              unselectedItemColor: iconBackground2,
              backgroundColor: appBarBackground)),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}
