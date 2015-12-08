package net.alhazmy13.libary;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alhazmy13 on 11/25/15.
 */
public class GotaActivity extends Activity {

    private Activity context;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=(Activity)Gota.context;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        pickImageWrapper();
       // finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        moveTaskToBack(true);
    }

    private void pickImageWrapper() {
        if (Build.VERSION.SDK_INT >= 23) {

           // List<String> permissionsNeeded = new ArrayList<String>();

            final List<String> permissionsList = new ArrayList<>();
            for(int i=0;i<Gota.permissions.size();i++){
                addPermission(permissionsList, Gota.permissions.get(i));
            }

            if (permissionsList.size() > 0) {
                ActivityCompat.requestPermissions(context, permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }

           // Gota.onPermissionSets.OnPermissionsGranted();
        }else{
         //   Gota.onPermissionSets.OnPermissionsGranted();
        }

    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (ActivityCompat.checkSelfPermission(context,permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!ActivityCompat.shouldShowRequestPermissionRationale(context,permission))
                return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
            {
                Map<String, Integer> perms = new HashMap<String, Integer>();
                // Initial
                for(int i=0;i<Gota.permissions.size();i++){
                    perms.put(Gota.permissions.get(i), PackageManager.PERMISSION_GRANTED);

                }
                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                // Check for ACCESS_FINE_LOCATION
                if (perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    // All Permissions Granted
                 //  Gota.onPermissionSets.OnPermissionsGranted();
                } else {
                //    // Permission Denied
                 //   Gota.onPermissionSets.OnPermissionDenied();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }




}
