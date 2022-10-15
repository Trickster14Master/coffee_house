import 'dart:convert';

import 'package:equatable/equatable.dart';

class UserEntity extends Equatable {
  UserEntity({
    required this.id,
    required this.userName,
    required this.userPassword,
  });

  final int id;
  final String userName;
  final String userPassword;

  @override
  List<Object?> get props => [
        id,
        userName,
        userPassword,
      ];
}
