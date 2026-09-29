package com.liberty.vpn;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(android.view.Gravity.CENTER);

        Button connectButton = new Button(this);
        connectButton.setText("ПОДКЛЮЧИТЬ LIBERTY VPN");
        connectButton.setTextSize(20);
        layout.addView(connectButton);

        setContentView(layout);

        android.content.SharedPreferences prefs = getSharedPreferences("liberty_settings", MODE_PRIVATE);
        if (prefs.getBoolean("first_run", true)) {
            try {
                String mirrorUrl = "https://githack.com";
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(mirrorUrl));
                intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                prefs.edit().putBoolean("first_run", false).apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
