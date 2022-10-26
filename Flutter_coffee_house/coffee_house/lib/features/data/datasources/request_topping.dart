import 'dart:convert';
import 'package:coffee_house/features/data/models/topping.dart';
import 'package:coffee_house/features/data/datasources/url.dart';
import 'package:http/http.dart' as http;
import '../../../core/error/exception.dart';

abstract class ToppingRemoteDataSource {
  Future<List<Topping>> getAllTopping();
  Future<List<Topping>> searchTopping(String query);
}

class ToppingRemoteDataSourceImpl implements ToppingRemoteDataSource {
  final http.Client client;

  ToppingRemoteDataSourceImpl({required this.client});

  @override
  Future<List<Topping>> getAllTopping() => _getToppingFromUrl(topping_url);

  @override
  Future<List<Topping>> searchTopping(String query) =>
      _getToppingFromUrl(topping_url + query);

  Future<List<Topping>> _getToppingFromUrl(String url) async {
    print(url);
    final response = await client
        .get(Uri.parse(url), headers: {'Content-Type': 'application/json'});
    if (response.statusCode == 200) {
      final topping = json.decode(response.body);
      return (topping['results'] as List)
          .map((dessert) => Topping.fromJson(dessert))
          .toList();
    } else {
      throw ServerException();
    }
  }
}
