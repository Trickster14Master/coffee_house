import 'package:coffee_house/features/domain/entities/dessert_entity.dart';
import 'package:dartz/dartz.dart';
import '../../../core/error/failure.dart';

abstract class DessertRepository {
  Future<Either<Failure, List<DessertEntity>>> getAllDessert();
  Future<Either<Failure, List<DessertEntity>>> searchDessert(String query);
}
