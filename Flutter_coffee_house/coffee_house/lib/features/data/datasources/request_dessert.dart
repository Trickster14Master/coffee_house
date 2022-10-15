import 'dart:convert';
import 'package:coffee_house/features/data/models/dessert.dart';
import 'package:coffee_house/features/data/datasources/url.dart';
import 'package:http/http.dart' as http;
import '../../../core/error/exception.dart';

abstract class DessertRemoteDataSource {
  Future<List<Dessert>> getAllDessert();
  Future<List<Dessert>> searchDessert(String query);
}

class DessertRemoteDataSourceImpl implements DessertRemoteDataSource {
  final http.Client client;

  DessertRemoteDataSourceImpl({required this.client});

  @override
  Future<List<Dessert>> getAllDessert() => _getDessertFromUrl(dessert_url);

  @override
  Future<List<Dessert>> searchDessert(String query) =>
      _getDessertFromUrl(dessert_url + query);

  Future<List<Dessert>> _getDessertFromUrl(String url) async {
    print(url);
    final response = await client
        .get(Uri.parse(url), headers: {'Content-Type': 'application/json'});
    if (response.statusCode == 200) {
      final dessert = json.decode(response.body);
      return (dessert['results'] as List)
          .map((dessert) => Dessert.fromJson(dessert))
          .toList();
    } else {
      throw ServerException();
    }
  }
}
