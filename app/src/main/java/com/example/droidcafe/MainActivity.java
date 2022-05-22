package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "droidcafe.extra.MESSAGE";

    String mOrderMessage;
    ImageView donutImgView = null;
    ImageView icecreamImgView = null;
    ImageView froyoImgView = null;
    FloatingActionButton floatingButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImgView = findViewById(R.id.donut);
        donutImgView.setOnClickListener(view -> {
            mOrderMessage = getString(R.string.donut_order_message);
            Toast.makeText(MainActivity.this, mOrderMessage, Toast.LENGTH_SHORT).show();
        });

        icecreamImgView = findViewById(R.id.icecream);
        icecreamImgView.setOnClickListener(view -> {
            mOrderMessage = getString(R.string.ice_cream_order_message);
            Toast.makeText(MainActivity.this, mOrderMessage, Toast.LENGTH_SHORT).show();
        });

        froyoImgView = findViewById(R.id.froyo);
        froyoImgView.setOnClickListener(view -> {
            mOrderMessage = getString(R.string.froyo_order_message);
            Toast.makeText(MainActivity.this, mOrderMessage, Toast.LENGTH_SHORT).show();
        });

        floatingButton = findViewById(R.id.floatingActionButton);
        floatingButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
            startActivity(intent);
        });
    }
}