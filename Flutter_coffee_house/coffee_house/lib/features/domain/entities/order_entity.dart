import 'dart:convert';

import 'package:equatable/equatable.dart';

class OrderEntity extends Equatable {
  const OrderEntity({
    required this.userToken,
    required this.date,
    required this.coffee,
    required this.topping,
    required this.dessert,
    required this.sumTable,
  });

  final String userToken;
  final DateTime date;
  final int coffee;
  final int topping;
  final int dessert;
  final int sumTable;

  @override
  List<Object?> get props => [
        userToken,
        date,
        coffee,
        topping,
        dessert,
        sumTable,
      ];
}
