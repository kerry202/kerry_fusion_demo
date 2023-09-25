import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:fusion/fusion.dart';

class TestPage extends StatefulWidget {
  final Map<String, dynamic>? arguments;
  late final MethodChannel _channel;

  TestPage({Key? key, this.arguments}) : super(key: key) {
    _channel = const MethodChannel('fusion');
  }

  @override
  State<TestPage> createState() => _TestPageState();
}

class _TestPageState extends State<TestPage>
    implements FusionNotificationListener, PageLifecycleListener {
  String msg = "";

  @override
  void onReceive(String name, Map<String, dynamic>? body) {
    print("  bodybody name=$name body =${body}");
    setState(() {
      msg = name;
    });
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    FusionNotificationBinding.instance.register(this);
    PageLifecycleBinding.instance.register(this);
  }

  @override
  void dispose() {
    super.dispose();
    FusionNavigator.instance.sendMessage("close");
    FusionNotificationBinding.instance.unregister(this);
    PageLifecycleBinding.instance.unregister(this);
    if (kDebugMode) {
      print('$runtimeType@$hashCode:dispose');
    }
  }

  @override
  void onBackground() {
    if (kDebugMode) {
      print('$runtimeType@$hashCode:onBackground');
    }
  }

  @override
  void onForeground() {
    if (kDebugMode) {
      print('$runtimeType@$hashCode:onForeground');
    }
  }

  @override
  void onPageInvisible() {
    if (kDebugMode) {
      print('$runtimeType@$hashCode:onPageInvisible');
    }
  }

  @override
  void onPageVisible() {
    if (kDebugMode) {
      print('$runtimeType@$hashCode:onPageVisible');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("flutter TestPage"),
      ),
      body: Center(
        child: Flex(
          direction: Axis.vertical,
          children: [
            Text(msg),
            TextButton(
                onPressed: () {
                  FusionNavigator.instance.push('/normal', {'title': '携带的参数'});
                },
                child: Text("go android normal activity")),
            TextButton(
                onPressed: () {
                  FusionNavigator.instance
                      .push('/testActivity', {'title': '携带的参数'});
                },
                child: Text("go android test activity"))
          ],
        ),
      ),
    );
  }
}
