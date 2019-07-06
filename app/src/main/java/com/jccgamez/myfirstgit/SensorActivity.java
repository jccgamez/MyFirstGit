package com.jccgamez.myfirstgit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensorAccelerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorAccelerator = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mSensorAccelerator, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorAccelerator, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rotation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];


        TextView txtMensaje = findViewById(R.id.txtMensaje);
        if(x<0) {

            txtMensaje.setText("HOLA");
        }
        else{txtMensaje.setText("ADIOS");}



        //        float dx, dy, dz;
        //        dx = (float) Math.sin(x);
        //        dy = (float) Math.sin(y);
        //        dz = (float) Math.sin(z);
        float ax, ay, az, anglexy,anglexz,angleyz;
        ax = x;
        ay = y;
        az = z;


        anglexy = (float) (Math.atan2(ax, ay) / (Math.PI / 180));
        anglexz = (float) (Math.atan2(ax, az) / (Math.PI / 180));
        angleyz = (float) (Math.atan2(ay, az) / (Math.PI / 180));

        TextView tvx = (TextView) findViewById(R.id.x_axis);
        TextView tvy = (TextView) findViewById(R.id.y_axis);
        TextView tvz = (TextView) findViewById(R.id.z_axis);
        TextView tAnglexy = (TextView) findViewById(R.id.angle);
        TextView tAnglexz = (TextView) findViewById(R.id.anglexz);
        TextView tAngleyz = (TextView) findViewById(R.id.angleyz);

        //        tvx.setText("X: " + dx);
        //        tvy.setText("Y: " + dy);
        //        tvz.setText("Z: " + dz);
        tvx.setText("X: " + String.format("%.3f",ax));
        tvy.setText("Y: " + String.format("%.3f",ay));
        tvz.setText("Z: " + String.format("%.3f",az));
        tAnglexy.setText("Angle: " + String.format("%.3f",anglexy));
        tAnglexz.setText("Angle: " + String.format("%.3f",anglexz));
        tAngleyz.setText("Angle: " + String.format("%.3f",angleyz));
    }

    @Override public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
