import 'package:equatable/equatable.dart';

// класс для обработки ошибок
abstract class Failure extends Equatable {
  @override
  List<Object> get props => [];
}

// ошибка связанна с сервером
class ServerFailure extends Failure {}
