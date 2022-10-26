import 'dart:convert';

import 'package:equatable/equatable.dart';

class ToppingEntity extends Equatable {
  const ToppingEntity({
    required this.id,
    required this.name,
    required this.price,
    required this.volume,
    required this.urlsImage,
  });

  final int id;
  final String name;
  final int price;
  final int volume;
  final String urlsImage;

  @override
  List<Object?> get props => [
        id,
        name,
        price,
        volume,
        urlsImage,
      ];
}
