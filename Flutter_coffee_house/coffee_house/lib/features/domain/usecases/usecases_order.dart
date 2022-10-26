import 'package:coffee_house/features/domain/entities/order_entity.dart';
import 'package:dartz/dartz.dart';
import 'package:equatable/equatable.dart';
import '../../../core/error/failure.dart';
import '../../../core/usecases/usecases.dart';
import '../repositories/order_repository.dart';

class PostOrder extends UseCase<List<OrderEntity>, PostOrderParams> {
  final OrderRepository orderRepository;
  PostOrder(this.orderRepository);

  Future<Either<Failure, List<OrderEntity>>> call(
      PostOrderParams params) async {
    return await orderRepository.postOrder(params.order);
  }
}

class SerchOrder extends UseCase<List<OrderEntity>, SerchOrderParams> {
  final OrderRepository orderRepository;
  SerchOrder(this.orderRepository);

  Future<Either<Failure, List<OrderEntity>>> call(
      SerchOrderParams params) async {
    return await orderRepository.searchOrder(params.query);
  }
}

class SerchOrderParams extends Equatable {
  final String query;

  SerchOrderParams({required this.query});

  @override
  List<Object?> get props => [query];
}

class PostOrderParams extends Equatable {
  final OrderEntity order;

  PostOrderParams({required this.order});

  @override
  List<Object?> get props => [order];
}
