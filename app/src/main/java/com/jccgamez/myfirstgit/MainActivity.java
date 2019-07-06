package com.jccgamez.myfirstgit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Comentario solo para cambiar el archivo
        //Hola

        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtPassword = findViewById(R.id.txtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnLista = findViewById(R.id.btnLista);
        Button btnSensor = findViewById(R.id.btnSensor);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"hola", Toast.LENGTH_LONG).show();
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirLista = new Intent(getBaseContext(),ListActivity.class);
                startActivity(abrirLista);
            }
        });

        btnSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirSensor = new Intent(getBaseContext(),SensorActivity.class);
                startActivity(abrirSensor);
            }
        });
    }
}
