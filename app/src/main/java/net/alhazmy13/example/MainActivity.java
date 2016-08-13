package net.alhazmy13.example;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.alhazmy13.gota.Gota;
import net.alhazmy13.gota.GotaResponse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Gota.OnRequestPermissionsBack {
    private static final String TAG = "MainActivity";
    private TextView camera,gps,call;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();




    }

    private void initViews() {
        gps = (TextView)findViewById(R.id.gpsStatus);
        call = (TextView)findViewById(R.id.callStatus);
        camera = (TextView) findViewById(R.id.cameraStatus);
        checkButton = (Button) findViewById(R.id.checkButton);
        checkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new Gota.Builder(this)
                .withPermissions(Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE)
                .requestId(1)
                .setListener(this)
                .check();

    }

    @Override
    public void onRequestBack(GotaResponse gotaResponse) {
        if(gotaResponse.isGranted(Manifest.permission.CAMERA)) {
            camera.setText("Allow");
            camera.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        }
        if(gotaResponse.isGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            gps.setText("Allow");
            gps.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

        }
        if(gotaResponse.isGranted(Manifest.permission.CALL_PHONE)) {
            call.setText("Allow");
            call.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

        }
        
        if(gotaResponse.isOnNeverAskAgain(Manifest.permission.CAMERA))
            Log.d(TAG, "onRequestBack: CAMERA");
    }
}
