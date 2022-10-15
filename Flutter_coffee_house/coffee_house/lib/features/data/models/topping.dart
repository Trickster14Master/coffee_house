import 'dart:convert';

Topping toppingFromJson(String str) => Topping.fromJson(json.decode(str));

String toppingToJson(Topping data) => json.encode(data.toJson());

// class Topping {
//   Topping({
//     required this.count,
//     this.next,
//     this.previous,
//     required this.results,
//   });

//   int count;
//   dynamic next;
//   dynamic previous;
//   List<Result> results;

//   factory Topping.fromJson(Map<String, dynamic> json) => Topping(
//         count: json["count"],
//         next: json["next"],
//         previous: json["previous"],
//         results:
//             List<Result>.from(json["results"].map((x) => Result.fromJson(x))),
//       );

//   Map<String, dynamic> toJson() => {
//         "count": count,
//         "next": next,
//         "previous": previous,
//         "results": List<dynamic>.from(results.map((x) => x.toJson())),
//       };
// }

class Topping {
  Topping({
    required this.id,
    required this.name,
    required this.price,
    required this.volume,
    required this.urlsImage,
  });

  int id;
  String name;
  int price;
  int volume;
  String urlsImage;

  factory Topping.fromJson(Map<String, dynamic> json) => Topping(
        id: json["id"],
        name: json["Name"],
        price: json["price"],
        volume: json["volume"],
        urlsImage: json["urlsImage"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "Name": name,
        "price": price,
        "volume": volume,
        "urlsImage": urlsImage,
      };
}
