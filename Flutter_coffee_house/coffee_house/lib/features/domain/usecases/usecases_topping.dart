import 'package:dartz/dartz.dart';
import 'package:equatable/equatable.dart';
import '../../../core/error/failure.dart';
import '../../../core/usecases/usecases.dart';
import '../entities/topping_entity.dart';
import '../repositories/topping_repository.dart';

class GetAllTopping extends ZeroUseCase<List<ToppingEntity>> {
  final ToppingRepository toppingRepository;
  GetAllTopping(this.toppingRepository);

  Future<Either<Failure, List<ToppingEntity>>> call() async {
    return await toppingRepository.getAllTopping();
  }
}

class SerchTopping extends UseCase<List<ToppingEntity>, SerchToppingParams> {
  final ToppingRepository toppingRepository;
  SerchTopping(this.toppingRepository);

  Future<Either<Failure, List<ToppingEntity>>> call(
      SerchToppingParams params) async {
    return await toppingRepository.searchTopping(params.query);
  }
}

class SerchToppingParams extends Equatable {
  final String query;

  const SerchToppingParams({required this.query});

  @override
  List<Object?> get props => [query];
}
