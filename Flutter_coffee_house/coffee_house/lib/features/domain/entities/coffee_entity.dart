import 'package:equatable/equatable.dart';

class CoffeeEntity extends Equatable {
  CoffeeEntity({
    required this.id,
    required this.name,
    required this.description,
    required this.price,
    required this.volume,
    required this.urls,
  });

  final int id;
  final String name;
  final String description;
  final int price;
  final int volume;
  final dynamic urls;

  @override
  List<Object?> get props => [
        id,
        name,
        description,
        price,
        volume,
        urls,
      ];
}
