import 'package:dartz/dartz.dart';
import '../../../core/error/failure.dart';
import '../entities/coffee_entity.dart';

abstract class CoffeeRepository {
  Future<Either<Failure, List<CoffeeEntity>>> getAllCoffee();
  Future<Either<Failure, List<CoffeeEntity>>> searchCoffee(String query);
}
