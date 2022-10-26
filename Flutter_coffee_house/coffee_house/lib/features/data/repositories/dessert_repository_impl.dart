import 'package:dartz/dartz.dart';
import 'package:coffee_house/features/domain/entities/dessert_entity.dart';
import 'package:coffee_house/core/error/failure.dart';
import '../../../core/platform/network_info.dart';
import '../../domain/repositories/dessert_repository.dart';
import '../datasources/request_dessert.dart';

class DessertRepositoryImpl implements DessertRepository {
  final DessertRemoteDataSource remoteDataSource;
  final NetworkInfo networkInfo;

  DessertRepositoryImpl({
    required this.remoteDataSource,
    required this.networkInfo,
  });

  @override
  Future<Either<Failure, List<DessertEntity>>> getAllDessert() {
    throw UnimplementedError();
  }

  @override
  Future<Either<Failure, List<DessertEntity>>> searchDessert(String query) {
    throw UnimplementedError();
  }
}
