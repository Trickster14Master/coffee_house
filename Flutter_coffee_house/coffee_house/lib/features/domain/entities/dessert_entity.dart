import 'package:equatable/equatable.dart';

class DessertEntity extends Equatable {
  const DessertEntity({
    required this.id,
    required this.name,
    required this.price,
    required this.urlsImage,
  });

  final int id;
  final String name;
  final int price;
  final String urlsImage;

  @override
  List<Object?> get props => [
        id,
        name,
        price,
        urlsImage,
      ];
}
