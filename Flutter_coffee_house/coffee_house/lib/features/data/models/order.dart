import 'dart:convert';

Order orderFromJson(String str) => Order.fromJson(json.decode(str));

String orderToJson(Order data) => json.encode(data.toJson());

// class Order {
//   Order({
//     required this.count,
//     this.next,
//     this.previous,
//     required this.results,
//   });

//   int count;
//   dynamic next;
//   dynamic previous;
//   List<Result> results;

//   factory Order.fromJson(Map<String, dynamic> json) => Order(
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

class Order {
  Order({
    required this.userToken,
    required this.date,
    required this.coffee,
    required this.topping,
    required this.dessert,
    required this.sumTable,
  });

  String userToken;
  DateTime date;
  int coffee;
  int topping;
  int dessert;
  int sumTable;

  factory Order.fromJson(Map<String, dynamic> json) => Order(
        userToken: json["userToken"],
        date: DateTime.parse(json["date"]),
        coffee: json["coffee"],
        topping: json["topping"],
        dessert: json["dessert"],
        sumTable: json["sum_table"],
      );

  Map<String, dynamic> toJson() => {
        "userToken": userToken,
        "date": date.toIso8601String(),
        "coffee": coffee,
        "topping": topping,
        "dessert": dessert,
        "sum_table": sumTable,
      };
}
