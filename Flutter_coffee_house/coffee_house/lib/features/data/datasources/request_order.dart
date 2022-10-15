import 'dart:convert';

import 'package:http/http.dart' as http;
import '../../../core/error/exception.dart';
import '../models/order.dart';
import 'url.dart';

abstract class OrderRemoteDataSource {
  Future<List<Order>> postOrder(dynamic object);
  Future<List<Order>> searchOrder(String query);
}

class OrderRemoteDataSourceImpl implements OrderRemoteDataSource {
  final http.Client client;

  OrderRemoteDataSourceImpl({required this.client});

  @override
  Future<List<Order>> postOrder(dynamic object) =>
      _postOrderFromUrl(order_url, object);

  @override
  Future<List<Order>> searchOrder(String query) =>
      _getOrderFromUrl(order_url + query);

  Future<List<Order>> _getOrderFromUrl(String url) async {
    print(url);
    final response = await client
        .get(Uri.parse(url), headers: {'Content-Type': 'application/json'});
    if (response.statusCode == 200) {
      final order = json.decode(response.body);
      return (order['results'] as List)
          .map((order) => Order.fromJson(order))
          .toList();
    } else {
      throw ServerException();
    }
  }

  Future<List<Order>> _postOrderFromUrl(String url, dynamic object) async {
    print(url);
    final response = await client.post(Uri.parse(url),
        body: object, headers: {'Content-Type': 'application/json'});
    if (response.statusCode == 201) {
      final order = json.decode(response.body);
      return (order['results'] as List)
          .map((order) => Order.fromJson(order))
          .toList();
    } else {
      throw ServerException();
    }
  }
}
