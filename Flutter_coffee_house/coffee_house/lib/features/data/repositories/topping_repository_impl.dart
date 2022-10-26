import 'package:dartz/dartz.dart';
import 'package:coffee_house/features/domain/entities/topping_entity.dart';
import 'package:coffee_house/core/error/failure.dart';
import '../../../core/platform/network_info.dart';
import '../../domain/repositories/topping_repository.dart';
import '../datasources/request_topping.dart';

class ToppingRepositoryImpl implements ToppingRepository {
  final ToppingRemoteDataSource remoteDataSource;
  final NetworkInfo networkInfo;

  ToppingRepositoryImpl({
    required this.remoteDataSource,
    required this.networkInfo,
  });

  @override
  Future<Either<Failure, List<ToppingEntity>>> getAllTopping() {
    throw UnimplementedError();
  }

  @override
  Future<Either<Failure, List<ToppingEntity>>> searchTopping(String query) {
    throw UnimplementedError();
  }


}