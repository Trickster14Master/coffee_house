import 'dart:convert';
import 'package:coffee_house/features/data/models/coffees.dart';
import 'package:http/http.dart' as http;
import '../../../core/error/exception.dart';
import 'url.dart';

abstract class CoffeeRemoteDataSource {
  Future<List<CoffeeModel>> getAllCoffee();
  Future<List<CoffeeModel>> searchCoffee(String query);
}

class CoffeeRemoteDataSourceImpl implements CoffeeRemoteDataSource {
  final http.Client client;

  CoffeeRemoteDataSourceImpl({required this.client});

  @override
  Future<List<CoffeeModel>> getAllCoffee() => _getCoffeeFromUrl(coffee_url);

  @override
  Future<List<CoffeeModel>> searchCoffee(String query) =>
      _getCoffeeFromUrl(coffee_url + query);

  // метод для запроса к API
  Future<List<CoffeeModel>> _getCoffeeFromUrl(String url) async {
    print(url);
    final response = await client
        .get(Uri.parse(url), headers: {'Content-Type': 'application/json'});
    if (response.statusCode == 200) {
      final coffee = json.decode(response.body);
      return (coffee['results'] as List)
          .map((coffee) => CoffeeModel.fromJson(coffee))
          .toList();
    } else {
      throw ServerException();
    }
  }
}
