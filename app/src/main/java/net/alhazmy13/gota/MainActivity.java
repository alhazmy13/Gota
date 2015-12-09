package net.alhazmy13.gota;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.alhazmy13.libary.GoaResponse;
import net.alhazmy13.libary.Gota;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Gota.OnPermissionSetListener {

    private TextView camera,gps,call;
    private Button checkButton;
    private String[] mPermissions;

    private static final int CAMERA=0;
    private static final int GPS=1;
    private static final int CALL=2;

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
        mPermissions=new String[]{Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE};
    }

    @Override
    public void onClick(View view) {
        new Gota(this).checkPermission(mPermissions,this);
    }

    @Override
    public void OnPermissionsBack(GoaResponse goaResponse) {
        if(goaResponse.isGranted(mPermissions[CAMERA])) {
            camera.setText("Granted");
            camera.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        }
        if(goaResponse.isGranted(mPermissions[GPS])) {
            gps.setText("Granted");
            gps.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

        }
        if(goaResponse.isGranted(mPermissions[CALL])) {
            call.setText("Granted");
            call.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

        }
    }


}
