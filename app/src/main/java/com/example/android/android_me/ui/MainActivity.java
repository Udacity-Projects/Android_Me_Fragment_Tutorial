package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.onImageClickListener {

    public int head = 0;
    public int body = 0;
    public int leg = 0;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button)findViewById(R.id.next_page);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("head", head);
                b.putInt("body", body);
                b.putInt("leg", leg);

                Intent in = new Intent(MainActivity.this, AndroidMeActivity.class);
                in.putExtras(b);
                startActivity(in);

            }
        });
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();

        if((position>=0) &&(position<=12)){
            head = position;
        }else if((position > 12) && (position <=24)){
            body = position -12;
        }
        else if((position>24) && (position<=35)){
            leg = position- 24;
        }
    }
}
