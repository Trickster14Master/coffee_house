import 'dart:convert';

Dessert dessertFromJson(String str) => Dessert.fromJson(json.decode(str));

String dessertToJson(Dessert data) => json.encode(data.toJson());

// class Dessert {
//   Dessert({
//     required this.count,
//     this.next,
//     this.previous,
//     required this.results,
//   });

//   int count;
//   dynamic next;
//   dynamic previous;
//   List<Result> results;

//   factory Dessert.fromJson(Map<String, dynamic> json) => Dessert(
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

class Dessert {
  Dessert({
    required this.id,
    required this.name,
    required this.price,
    required this.urlsImage,
  });

  int id;
  String name;
  int price;
  String urlsImage;

  factory Dessert.fromJson(Map<String, dynamic> json) => Dessert(
        id: json["id"],
        name: json["name"],
        price: json["price"],
        urlsImage: json["urlsImage"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "price": price,
        "urlsImage": urlsImage,
      };
}
