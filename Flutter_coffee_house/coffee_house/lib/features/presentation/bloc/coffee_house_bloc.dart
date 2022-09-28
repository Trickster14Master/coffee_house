import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';

part 'coffee_house_event.dart';
part 'coffee_house_state.dart';

class CoffeeHouseBloc extends Bloc<CoffeeHouseEvent, CoffeeHouseState> {
  CoffeeHouseBloc() : super(CoffeeHouseInitial()) {
    on<CoffeeHouseEvent>((event, emit) {
      // TODO: implement event handler
    });
  }
}
