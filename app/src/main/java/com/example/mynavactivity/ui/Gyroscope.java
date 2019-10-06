package com.example.mynavactivity.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mynavactivity.R;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Gyroscope extends AppCompatActivity implements SensorEventListener {
    private TextView xtext,ytext,ztext;
    private Sensor mySensor;
    private SensorManager SM;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        setTitle("Gyroscope Sensor Test");

        SM=(SensorManager)getSystemService(SENSOR_SERVICE);

        mySensor=SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        xtext=findViewById(R.id.xtext);
        ytext=findViewById(R.id.ytext);
        ztext=findViewById(R.id.ztext);

        databaseReference = FirebaseDatabase.getInstance().getReference("GyroscopeData");
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        xtext.setText("X: " + (int)x);
        ytext.setText("Y: " + (int)y);
        ztext.setText("Z: " + (int)z);

        if((int)x != 0 || (int)y!= 0 || (int)z != 0){
            String key = databaseReference.push().getKey();

            Gyro gyro = new Gyro(String.valueOf((int)x),String.valueOf((int)y),String.valueOf((int)z));

            databaseReference.child(key).setValue(gyro);

            Toast.makeText(Gyroscope.this,"New data is saved",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    protected void onResume()
    {
        super.onResume();
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);    }
    protected void onPause()
    {
        super.onPause();
        SM.unregisterListener(this);
    }
}