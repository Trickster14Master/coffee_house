import 'package:coffee_house/features/domain/entities/coffee_entity.dart';

// class Coffee {
//     Coffee({
//         required this.count,
//         required this.next,
//         required this.previous,
//         required this.results,
//     });

//     int count;
//     dynamic next;
//     dynamic previous;
//     List<Result> results;

//     factory Coffee.fromJson(Map<String, dynamic> json) => Coffee(
//         count: json["count"],
//         next: json["next"],
//         previous: json["previous"],
//         results: List<Result>.from(json["results"].map((x) => Result.fromJson(x))),
//     );

//     Map<String, dynamic> toJson() => {
//         "count": count,
//         "next": next,
//         "previous": previous,
//         "results": List<dynamic>.from(results.map((x) => x.toJson())),
//     };
// }

class CoffeeModel extends CoffeeEntity {
  CoffeeModel({
    required id,
    required name,
    required description,
    required price,
    required volume,
    required urls,
  }) : super(
            id: id,
            name: name,
            description: description,
            price: price,
            volume: volume,
            urls: urls);

  factory CoffeeModel.fromJson(Map<String, dynamic> json) {
    return CoffeeModel(
      id: json["id"],
      name: json["name"],
      description: json["description"],
      price: json["price"],
      volume: json["volume"],
      urls: json["urls"],
    );
  }

  Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "description": description,
        "price": price,
        "volume": volume,
        "urls": urls,
      };
}
