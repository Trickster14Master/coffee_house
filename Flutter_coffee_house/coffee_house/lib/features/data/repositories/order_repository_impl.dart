import 'package:dartz/dartz.dart';
import 'package:coffee_house/features/domain/entities/order_entity.dart';
import 'package:coffee_house/core/error/failure.dart';
import '../../../core/platform/network_info.dart';
import '../../domain/repositories/order_repository.dart';
import '../datasources/request_order.dart';

class OrderRepositoryImpl implements OrderRepository {
  final OrderRemoteDataSource remoteDataSource;
  final NetworkInfo networkInfo;

  OrderRepositoryImpl({
    required this.remoteDataSource,
    required this.networkInfo,
  });

  @override
  Future<Either<Failure, List<OrderEntity>>> postOrder(OrderEntity order) {
    throw UnimplementedError();
  }

  @override
  Future<Either<Failure, List<OrderEntity>>> searchOrder(String query) {
    throw UnimplementedError();
  }


}