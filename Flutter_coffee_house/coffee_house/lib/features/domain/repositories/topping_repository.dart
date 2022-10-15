import 'package:coffee_house/features/domain/entities/topping_entity.dart';
import 'package:dartz/dartz.dart';
import '../../../core/error/failure.dart';

abstract class ToppingRepository {
  Future<Either<Failure, List<ToppingEntity>>> getAllTopping();
  Future<Either<Failure, List<ToppingEntity>>> searchTopping(String query);
}
