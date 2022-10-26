import 'package:equatable/equatable.dart';

class UserEntity extends Equatable {
  final int id;
  final String userName;
  final String userPassword;

  const UserEntity({
    required this.id,
    required this.userName,
    required this.userPassword,
  });

  @override
  List<Object?> get props => [
        id,
        userName,
        userPassword,
      ];
}
