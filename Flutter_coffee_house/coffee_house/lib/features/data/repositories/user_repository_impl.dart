import 'package:dartz/dartz.dart';

import 'package:coffee_house/features/domain/entities/user_entity.dart';

import 'package:coffee_house/core/error/failure.dart';

import '../../../core/platform/network_info.dart';
import '../../domain/repositories/user_repository.dart';
import '../datasources/request_user.dart';

class UserRepositoryImpl implements UserRepository {
  final UserRemoteDataSource remoteDataSource;
  final NetworkInfo networkInfo;

  UserRepositoryImpl({
    required this.remoteDataSource,
    required this.networkInfo,
  });

  @override
  Future<Either<Failure, List<UserEntity>>> postUser(UserEntity user) {
    throw UnimplementedError();
  }

  @override
  Future<Either<Failure, List<UserEntity>>> searchUser(String query) {
    throw UnimplementedError();
  }
}
