package net.alhazmy13.gota;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.alhazmy13.libary.Gota;

public class MainActivity extends AppCompatActivity implements Gota.OnPermissionSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.button);
        //();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gota gota=new Gota(MainActivity.this);
                gota.setOnPermissionSetListener(MainActivity.this);
                gota.requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA);
            }
        });
    }

    @Override
    public void OnPermissionsGranted() {
        Toast.makeText(this,"Granted",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnPermissionDenied() {
        Toast.makeText(this,"Denied",Toast.LENGTH_SHORT).show();
    }
}
