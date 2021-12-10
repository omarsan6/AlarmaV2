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

public class registrar extends AppCompatActivity {

    EditText etUsuario;
    EditText etConfirmarUsuario;
    Button btnUnete;
    TextView btnYaCuenta;
    daoUsuario dao;

    public void init(){
        etUsuario=(EditText)findViewById(R.id.etUsuario);
        etConfirmarUsuario=(EditText)findViewById(R.id.etConfirmarUsuario);
        btnUnete=(Button)findViewById(R.id.btnUnete);
        btnYaCuenta=(TextView)findViewById(R.id.btnYaCuenta);
        dao = new daoUsuario(this);
    }

    public void activities(){
        btnYaCuenta = findViewById(R.id.btnYaCuenta);
        btnYaCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registrar.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnUnete = findViewById(R.id.btnUnete);
        btnUnete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario u = new Usuario();
                u.setUsuario(etUsuario.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(registrar.this, "Error: campos vacios", Toast.LENGTH_LONG).show();
                } else if(dao.insertUsuario(u)){

                    Toast.makeText(registrar.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(registrar.this, "Usuario ya registrado", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        init();
        activities();


    }
}