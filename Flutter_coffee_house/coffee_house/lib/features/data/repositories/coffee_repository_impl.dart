import 'package:coffee_house/features/data/models/coffees.dart';
import 'package:dartz/dartz.dart';
import 'package:coffee_house/features/domain/entities/coffee_entity.dart';
import 'package:coffee_house/core/error/failure.dart';
import '../../../core/error/exception.dart';
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
  Future<Either<Failure, List<CoffeeEntity>>> getAllCoffee() async {
    return await _getCoffee(() {
      return remoteDataSource.getAllCoffee();
    });
  }

  @override
  Future<Either<Failure, List<CoffeeEntity>>> searchCoffee(String query) async {
    return await _getCoffee(() {
      return remoteDataSource.searchCoffee(query);
    });
  }

  Future<Either<Failure, List<CoffeeModel>>> _getCoffee(
      Future<List<CoffeeModel>> Function() getCoffee) async {
    if (await networkInfo.isConnected) {
      try {
        final remoteCoffe = await getCoffee();
        return Right(remoteCoffe);
      } on ServerException {
        return Left(ServerFailure());
      }
      // если данные не пришли
    } else {
      return Left(ServerFailure());
    }
  }
}
