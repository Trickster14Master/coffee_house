import 'package:coffee_house/features/domain/entities/coffee_entity.dart';
import 'package:dartz/dartz.dart';
import 'package:equatable/equatable.dart';
import '../../../core/error/failure.dart';
import '../../../core/usecases/usecases.dart';
import '../repositories/coffe_repository.dart';

class GetAllCoffee extends ZeroUseCase<List<CoffeeEntity>> {
  // пекременная для репозитория
  final CoffeeRepository coffeeRepository;
  GetAllCoffee(this.coffeeRepository);

  // метод для получения персонажей из репозитория
  Future<Either<Failure, List<CoffeeEntity>>> call() async {
    return await coffeeRepository.getAllCoffee();
  }
}

class SerchCoffee extends UseCase<List<CoffeeEntity>, SerchCoffeeParams> {
  final CoffeeRepository coffeeRepository;
  SerchCoffee(this.coffeeRepository);

  Future<Either<Failure, List<CoffeeEntity>>> call(
      SerchCoffeeParams params) async {
    return await coffeeRepository.searchCoffee(params.query);
  }
}

class SerchCoffeeParams extends Equatable {
  final String query;

  SerchCoffeeParams({required this.query});

  @override
  List<Object?> get props => [query];
}
