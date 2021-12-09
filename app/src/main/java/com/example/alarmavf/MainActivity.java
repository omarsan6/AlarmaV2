package com.example.alarmavf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    TextView registrate;

    public void abrirActividades(){
        //abre a la actividad crear_alarma
        //siguiente = findViewById(R.id.btnIncio);
        /*siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, crear_alarma.class);
                startActivity(intent);
            }
        });*/

        //abre a la actividad registrate
        registrate = findViewById(R.id.btnRegistrate);
        registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registrar.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abrirActividades();
    }

}