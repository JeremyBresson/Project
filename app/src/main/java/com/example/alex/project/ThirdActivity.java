package com.example.alex.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    private double resultat;
    private boolean clicOperateur = false;
    private String operateur = "";
    private boolean update = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        dialog();
    }

        public void dialog () {



            Button button0 = (Button) findViewById(R.id.btn0);
            Button button1 = (Button) findViewById(R.id.btn1);
            Button button2 = (Button) findViewById(R.id.btn2);
            Button button3 = (Button) findViewById(R.id.btn3);
            Button button4 = (Button) findViewById(R.id.btn4);
            Button button5 = (Button) findViewById(R.id.btn5);
            Button button6 = (Button) findViewById(R.id.btn6);
            Button button7 = (Button) findViewById(R.id.btn7);
            Button button8 = (Button) findViewById(R.id.btn8);
            Button button9 = (Button) findViewById(R.id.btn9);
            Button button_e = (Button) findViewById(R.id.btn_e);


            button_e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    egalClick();
                }
            });

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("0");
                }
            });

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("1");
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("2");
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("3");
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("4");
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("5");
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("6");
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("7");
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("8");
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chiffreclick("9");
                }
            });


        }
            public void chiffreclick (String str) {
                EditText ecran = (EditText) findViewById(R.id.text_test);
                boolean update = false;
                if(update){
                    update = false;
                }
                else{
                    if(!ecran.getText().equals("0"))
                        str = ecran.getText() + str;
                }
                ecran.setText(str);
            }

            public void egalClick(){
                EditText ecran = (EditText) findViewById(R.id.text_test);
                Double resultat = 0.25*Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText("Tu as environ " + String.valueOf(resultat) + "g/l d'alcool dans le sang,  peut mieux faire !");
                update = true;
                clicOperateur = false;
            }


}




