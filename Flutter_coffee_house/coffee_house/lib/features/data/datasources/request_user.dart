import 'dart:convert';
import 'package:coffee_house/features/data/models/user.dart';
import 'package:http/http.dart' as http;
import '../../../core/error/exception.dart';
import 'url.dart';

abstract class UserRemoteDataSource {
  Future<List<User>> postUser(dynamic object);
  Future<List<User>> searchUser(String query);
}

class UserRemoteDataSourceImpl implements UserRemoteDataSource {
  final http.Client client;

  UserRemoteDataSourceImpl({required this.client});

  @override
  Future<List<User>> postUser(dynamic object) =>
      _postUserFromUrl(order_url, object);

  @override
  Future<List<User>> searchUser(String query) =>
      _getUserFromUrl(order_url + query);

  Future<List<User>> _getUserFromUrl(String url) async {
    print(url);
    final response = await client
        .get(Uri.parse(url), headers: {'Content-Type': 'application/json'});
    if (response.statusCode == 200) {
      final user = json.decode(response.body);
      return (user['results'] as List)
          .map((order) => User.fromJson(order))
          .toList();
    } else {
      throw ServerException();
    }
  }

  Future<List<User>> _postUserFromUrl(String url, dynamic object) async {
    print(url);
    final response = await client.post(Uri.parse(url),
        body: object, headers: {'Content-Type': 'application/json'});
    if (response.statusCode == 201) {
      final user = json.decode(response.body);
      return (user['results'] as List)
          .map((order) => User.fromJson(order))
          .toList();
    } else {
      throw ServerException();
    }
  }
}
