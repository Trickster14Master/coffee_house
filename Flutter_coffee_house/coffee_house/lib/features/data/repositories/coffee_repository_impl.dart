import 'package:dartz/dartz.dart';
import 'package:coffee_house/features/domain/entities/coffee_entity.dart';
import 'package:coffee_house/core/error/failure.dart';
import '../../../core/platform/network_info.dart';
import '../../domain/repositories/coffe_repository.dart';
import '../datasources/request_coffees.dart';

class CoffeeRepositoryImpl implements CoffeeRepository {
  final CoffeeRemoteDataSource remoteDataSource;
  final NetworkInfo networkInfo;

  CoffeeRepositoryImpl({
    required this.remoteDataSource,
    required this.networkInfo,
  });

  @override
  Future<Either<Failure, List<CoffeeEntity>>> getAllCoffee() {
    throw UnimplementedError();
  }

  @override
  Future<Either<Failure, List<CoffeeEntity>>> searchCoffee(String query) {
    throw UnimplementedError();
  }
}
