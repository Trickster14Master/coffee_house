import 'package:coffee_house/features/domain/entities/user_entity.dart';

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

class User extends UserEntity {
  User({
    required id,
    required userName,
    required userPassword,
  }) : super(id: id, userName: userName, userPassword: userPassword);

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
