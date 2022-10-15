import 'package:coffee_house/features/domain/entities/order_entity.dart';
import 'package:dartz/dartz.dart';
import '../../../core/error/failure.dart';

abstract class OrderRepository {
  Future<Either<Failure, List<OrderEntity>>> postOrder(dynamic object);
  Future<Either<Failure, List<OrderEntity>>> searchOrder(String query);
}
