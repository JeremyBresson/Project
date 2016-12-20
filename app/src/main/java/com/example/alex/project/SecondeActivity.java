package com.example.alex.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);

        DialogbtnKro();
        DialogbtnArtois();
        DialogbtnGuiness();
    }



    public void DialogbtnKro() {

        ImageView btn_kro = (ImageView) findViewById(R.id.image_kro);
        btn_kro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Redirection sur le site Kronenbourg", Toast.LENGTH_LONG).show();
                //ImageView btn_kro = (ImageView) findViewById(R.id.image_kro);
                //btn_kro.setImageResource(R.drawable.lkro);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kronenbourg.fr"));
                startActivity(intent);
            }
        });
    }

    public void DialogbtnArtois() {

        ImageView btn_artois = (ImageView) findViewById(R.id.image_artois);
        btn_artois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Redirection sur le site Stella Artois", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stellaartois.com"));
                startActivity(intent);
            }
        });
    }

    public void DialogbtnGuiness() {

        ImageView btn_guiness = (ImageView) findViewById(R.id.image_guiness);
        btn_guiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Redirection sur le site Guiness", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.guinness.com"));
                startActivity(intent);
            }
        });
    }



}

