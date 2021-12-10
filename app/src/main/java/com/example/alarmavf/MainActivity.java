package com.example.alarmavf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alarmavf.controladores.daoUsuario;
import com.example.alarmavf.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    TextView registrate;
    EditText etUser;
    daoUsuario dao;

    public void init(){
        etUser=(EditText)findViewById(R.id.etUser);
        dao = new daoUsuario(this);
    }

    public void abrirActividades(){
        //abre a la actividad crear_alarma


        //abre a la actividad registrate
        registrate = findViewById(R.id.btnYaCuenta);
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
        init();

        siguiente = findViewById(R.id.btnInicio);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String u = etUser.getText().toString();
                if(u.equals("")){
                    Toast.makeText(MainActivity.this, "Error: Campos vacios", Toast.LENGTH_SHORT).show();
                } else if(dao.login(u)==1){
                    Usuario ux = dao.getUsuario(u);
                    Intent intent = new Intent(MainActivity.this, crear_alarma.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(MainActivity.this, "Error: Campos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}