package net.alhazmy13.gota;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.alhazmy13.libary.Gota;
import net.alhazmy13.libary.GotaResponce;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton=(Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Gota gota = new Gota(MainActivity.this);
                gota.checkPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, new Gota.OnPermissionSetListener() {
                    @Override
                    public void OnPermissionsBack(GotaResponce gotaResponce) {
                        if (gotaResponce.isAllDenied())
                            Toast.makeText(MainActivity.this, "Denied", Toast.LENGTH_SHORT).show();
                        if (gotaResponce.isAllGranted())
                            Toast.makeText(MainActivity.this, "Granted", Toast.LENGTH_SHORT).show();
                        if (gotaResponce.deniedPermissions().length>0)
                            Toast.makeText(MainActivity.this,gotaResponce.deniedPermissions()[0], Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }

}
