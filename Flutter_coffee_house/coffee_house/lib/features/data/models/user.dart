import 'dart:convert';

User userFromJson(String str) => User.fromJson(json.decode(str));

String userToJson(User data) => json.encode(data.toJson());

// class User {
//   User({
//     required this.count,
//     this.next,
//     this.previous,
//     required this.results,
//   });

//   int count;
//   dynamic next;
//   dynamic previous;
//   List<Result> results;

//   factory User.fromJson(Map<String, dynamic> json) => User(
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

class User {
  User({
    required this.id,
    required this.userName,
    required this.userPassword,
  });

  int id;
  String userName;
  String userPassword;

  factory User.fromJson(Map<String, dynamic> json) => User(
        id: json["id"],
        userName: json["userName"],
        userPassword: json["userPassword"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "userName": userName,
        "userPassword": userPassword,
      };
}
