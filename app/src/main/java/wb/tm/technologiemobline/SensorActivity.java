package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {

    private SensorManager mSensorManager;
    private List<Sensor> sensorList = null;
    private Button showSensorsButton;

    private TextView list;
    private TextView lightLabel;
    private TextView proximityLabel;
    private Sensor mProximity;
    private Sensor mLight;

    private  TextView akcelLabel;
    private TextView kompasLabel;
    private Sensor mAkcelerometr;
    private Sensor mKompas;

    private TextView orientationLabel;
    private float[] mAkcelerometrData = new float[3];
    private float[] mKompasData = new float[3];
    private float[] mOrientation = new float[3];
    private float[] mRotationMatrix = new float[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        showSensorsButton = findViewById(R.id.showSensorB);
        showSensorsButton.setOnClickListener(this);
        list = findViewById(R.id.listaTv);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightLabel = findViewById(R.id.labelLight);
        proximityLabel = findViewById(R.id.labelProximity);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (mProximity == null) proximityLabel.setText("sensor_error");
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight == null) lightLabel.setText("sensor_error");

        akcelLabel = findViewById(R.id.akcelerometrLabel);
        kompasLabel = findViewById(R.id.kompasLabel);
        orientationLabel = findViewById(R.id.orientLabel);

        mAkcelerometr = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mKompas = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mAkcelerometr == null) akcelLabel.setText("sensor_error");
        if (mKompas == null) kompasLabel.setText("sensor_error");
    }
    @Override
    protected  void onStart() {
        super.onStart();

        if(mProximity != null) {
            mSensorManager.registerListener(this,mProximity,mSensorManager.SENSOR_DELAY_NORMAL);
        }
        if(mLight != null) {
            mSensorManager.registerListener(this,mLight,mSensorManager.SENSOR_DELAY_NORMAL);
        }
        if(mAkcelerometr != null) {
            mSensorManager.registerListener(this,mAkcelerometr,mSensorManager.SENSOR_DELAY_NORMAL);
        }
        if(mKompas != null) {
            mSensorManager.registerListener(this,mKompas,mSensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];
        switch (sensorType) {
            case Sensor.TYPE_PROXIMITY:
                proximityLabel.setText(getResources().getString(R.string.proximity_label, currentValue));
                break;
            case Sensor.TYPE_LIGHT:
                lightLabel.setText(String.format("Light sensor = %2.f", currentValue));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                mAkcelerometrData = sensorEvent.values.clone();
                akcelLabel.setText(getResources().getString(R.string.akce_label,mAkcelerometrData[0],mAkcelerometrData[1],mAkcelerometrData[2]));
                break;
//            case Sensor.TYPE_MAGNETIC_FIELD:
//                mKompasData = sensorEvent.values.clone();
//                kompasLabel.setText(getResources().getString(R.string.kompas_label,mKompasData[0],mKompasData[1],mKompasData[3]));
        }
        boolean rotationOK = SensorManager.getRotationMatrix(mRotationMatrix,null,mAkcelerometrData,mKompasData);
        if (rotationOK){
            SensorManager.getOrientation(mRotationMatrix, mOrientation);
            orientationLabel.setText("Orient: {mOrientation[0] * 180 / Math.PI} : {mOrientation[1] * 180 / Math.PI} : mOrientation[2] * 180 / Math.PI");
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showSensorB:
                showSensors();
                break;
        }
    }

    private void showSensors() {
        sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensors = new StringBuilder();
        for (Sensor sensor : sensorList){
            sensors.append(sensor.getName()).append(System.getProperty("line.separator"));
        }
        list.setText("");
        list.setText("Sensor's lists: \n\n" + sensors);
    }
}