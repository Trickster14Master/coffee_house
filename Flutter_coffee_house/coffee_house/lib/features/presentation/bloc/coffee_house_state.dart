part of 'coffee_house_bloc.dart';

abstract class CoffeeHouseState extends Equatable {
  const CoffeeHouseState();  

  @override
  List<Object> get props => [];
}
class CoffeeHouseInitial extends CoffeeHouseState {}
