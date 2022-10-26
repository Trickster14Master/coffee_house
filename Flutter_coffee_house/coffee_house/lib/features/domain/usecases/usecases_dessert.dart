import 'package:coffee_house/features/domain/entities/dessert_entity.dart';
import 'package:dartz/dartz.dart';
import 'package:equatable/equatable.dart';
import '../../../core/error/failure.dart';
import '../../../core/usecases/usecases.dart';
import '../repositories/dessert_repository.dart';

class GetAllDessert extends ZeroUseCase<List<DessertEntity>> {
  final DessertRepository dessertRepository;
  GetAllDessert(this.dessertRepository);

  Future<Either<Failure, List<DessertEntity>>> call() async {
    return await dessertRepository.getAllDessert();
  }
}

class SerchDessert extends UseCase<List<DessertEntity>, SerchDessertParams> {
  final DessertRepository dessertRepository;
  SerchDessert(this.dessertRepository);

  Future<Either<Failure, List<DessertEntity>>> call(
      SerchDessertParams params) async {
    return await dessertRepository.searchDessert(params.query);
  }
}

class SerchDessertParams extends Equatable {
  final String query;

  SerchDessertParams({required this.query});

  @override
  List<Object?> get props => [query];
}
