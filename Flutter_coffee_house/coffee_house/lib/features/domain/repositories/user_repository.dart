import 'package:coffee_house/features/domain/entities/topping_entity.dart';
import 'package:coffee_house/features/domain/entities/user_entity.dart';
import 'package:dartz/dartz.dart';
import '../../../core/error/failure.dart';

abstract class UserRepository {
  Future<Either<Failure, List<UserEntity>>> postUser(dynamic object);
  Future<Either<Failure, List<UserEntity>>> searchUser(String query);
}
