// To parse this JSON data, do
//
//     final coffee = coffeeFromJson(jsonString);

import 'dart:convert';

Coffee coffeeFromJson(String str) => Coffee.fromJson(json.decode(str));

String coffeeToJson(Coffee data) => json.encode(data.toJson());

class Coffee {
    Coffee({
        required this.count,
        required this.next,
        required this.previous,
        required this.results,
    });

    int count;
    dynamic next;
    dynamic previous;
    List<Result> results;

    factory Coffee.fromJson(Map<String, dynamic> json) => Coffee(
        count: json["count"],
        next: json["next"],
        previous: json["previous"],
        results: List<Result>.from(json["results"].map((x) => Result.fromJson(x))),
    );

    Map<String, dynamic> toJson() => {
        "count": count,
        "next": next,
        "previous": previous,
        "results": List<dynamic>.from(results.map((x) => x.toJson())),
    };
}

class Result {
    Result({
        required this.id,
        required this.name,
        required this.description,
        required this.price,
        required this.volume,
        required this.urls,
    });

    int id;
    String name;
    String description;
    int price;
    int volume;
    dynamic urls;

    factory Result.fromJson(Map<String, dynamic> json) => Result(
        id: json["id"],
        name: json["name"],
        description: json["description"],
        price: json["price"],
        volume: json["volume"],
        urls: json["urls"],
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "description": description,
        "price": price,
        "volume": volume,
        "urls": urls,
    };
}
