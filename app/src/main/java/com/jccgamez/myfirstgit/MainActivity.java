package com.jccgamez.myfirstgit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Comentario solo para cambiar el archivo 
        //Hola
        //Adios

        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtPassword = findViewById(R.id.txtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnLista = findViewById(R.id.btnLista);
        Button btnSensor = findViewById(R.id.btnSensor);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"hola", Toast.LENGTH_LONG).show();
                try {
                    //new HTTPAsyncTask().HttpPost("http://locreas.com/ws/login.php");
                    PeticionAsincrona  peticion = new PeticionAsincrona();
                    peticion.HttpPost("http://locreas.com/ws/login.php");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

    private class PeticionAsincrona extends AsyncTask<String, Void, String> {
        private String HttpPost(String myUrl) throws IOException, JSONException {
            String result = "";
            URL url = new URL(myUrl);
            // HttpURLConnection es la clase con la que hacemos un request a un webservice
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

            // Creamos objeto json y le agregamos los valores de lass cajas de texto
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("usuario", "fauno");
            jsonObject.accumulate("password", "fauno*");

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            writer.write(jsonObject.toString());
            System.out.println("MS " + jsonObject.toString());
            Log.i(MainActivity.class.toString(), jsonObject.toString());
            writer.flush();
            writer.close();
            os.close();

            conn.connect();

            // 5. return response message
            return conn.getResponseMessage()+"";

        }



        @Override
        protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            try {
                try {
                    return HttpPost(urls[0]);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return "Error!";
                }
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

        }
    }
}
