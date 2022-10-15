import 'package:internet_connection_checker/internet_connection_checker.dart';

abstract class NetworkInfo {
  Future<bool> get isConnected;
}

class NetworkInfoImpl implements NetworkInfo {
  // переменная для хранения данных о подключении
  final InternetConnectionChecker connectionChecker;
  NetworkInfoImpl(this.connectionChecker);

  @override
  // узнаём естьли подключение
  Future<bool> get isConnected => connectionChecker.hasConnection;
}
