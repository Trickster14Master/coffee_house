import 'package:dartz/dartz.dart';
import '../error/failure.dart';

// абстактный класс для того чтобы у методов класса были одинаковые имена, Type -  тип возврата без ошибок, Params - параветор для изменения кейсов
abstract class UseCase<Type, Params> {
  Future<Either<Failure, Type>> call(Params params);
}

abstract class ZeroUseCase<Type> {
  Future<Either<Failure, Type>> call();
}
