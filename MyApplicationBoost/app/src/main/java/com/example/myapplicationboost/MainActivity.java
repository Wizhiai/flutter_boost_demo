package com.example.myapplicationboost;

import androidx.appcompat.app.AppCompatActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> params = new HashMap<>();
                params.put("string", "a string");
                params.put("bool", true);
                params.put("int", 666);

                Intent intent = new FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity.class)
                        .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.opaque)
                        .destroyEngineWithActivity(false)
                        .url("simplePage") //在main.dart的routerMap中有注册 对应的这个url
                        .urlParams(params)
                        .build(MainActivity.this);
                startActivity(intent);
            }
        });
    }
}