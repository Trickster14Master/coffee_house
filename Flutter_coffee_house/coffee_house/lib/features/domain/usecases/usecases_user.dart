import 'package:coffee_house/features/domain/entities/user_entity.dart';
import 'package:dartz/dartz.dart';
import 'package:equatable/equatable.dart';
import '../../../core/error/failure.dart';
import '../../../core/usecases/usecases.dart';
import '../repositories/user_repository.dart';

class PostUser extends UseCase<List<UserEntity>, PostUserParams> {
  final UserRepository userRepository;
  PostUser(this.userRepository);

  Future<Either<Failure, List<UserEntity>>> call(PostUserParams params) async {
    return await userRepository.postUser(params.user);
  }
}

class SerchUser extends UseCase<List<UserEntity>, SerchUserParams> {
  final UserRepository userRepository;
  SerchUser(this.userRepository);

  Future<Either<Failure, List<UserEntity>>> call(SerchUserParams params) async {
    return await userRepository.searchUser(params.query);
  }
}

class SerchUserParams extends Equatable {
  final String query;

  SerchUserParams({required this.query});

  @override
  List<Object?> get props => [query];
}

class PostUserParams extends Equatable {
  final UserEntity user;

  PostUserParams({required this.user});

  @override
  List<Object?> get props => [user];
}
