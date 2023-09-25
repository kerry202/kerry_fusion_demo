import 'package:flutter/material.dart';
import 'package:fusion/fusion.dart';

class MinePage extends StatefulWidget {
  final dynamic arguments;

  const MinePage({Key? key, required this.arguments}) : super(key: key);

  @override
  State<MinePage> createState() => _MinePageState();
}

class _MinePageState extends State<MinePage>
    implements FusionNotificationListener {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("_MinePageState"),
      ),
      body: Text("MinePage"),
    );
  }

  @override
  void onReceive(String name, Map<String, dynamic>? body) {}

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    FusionNotificationBinding.instance.register(this);
  }

  @override
  void dispose() {
    super.dispose();
    FusionNotificationBinding.instance.unregister(this);
  }
}
