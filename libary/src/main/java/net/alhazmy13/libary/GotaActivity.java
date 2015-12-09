package net.alhazmy13.libary;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alhazmy13 on 11/25/15.
 */
public class GotaActivity extends Activity {

   // private Activity mContext;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 1;
    private List<String> mPermissionsList;
    private Map<String, Integer> perms = new HashMap<String, Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  mContext=(Activity)Gota.context;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        init();
        checkPermissions();



    }

    private void init() {
        mPermissionsList=new ArrayList<>();
        for(int i=0;i<Gota.permissions.size();i++){
            perms.put(Gota.permissions.get(i), PackageManager.PERMISSION_GRANTED);
        }
        for(int i=0;i<Gota.permissions.size();i++){
            addPermission(mPermissionsList, Gota.permissions.get(i));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        moveTaskToBack(true);
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (mPermissionsList.size() > 0) {
                ActivityCompat.requestPermissions(this, mPermissionsList.toArray(new String[mPermissionsList.size()]),
                        REQUEST_CODE_ASK_PERMISSIONS);
            }else {
                Gota.onPermissionSets.OnPermissionsBack(new GoaResponse(perms));
            }

        }else{
            Gota.onPermissionSets.OnPermissionsBack(new GoaResponse(perms));

        }

    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (ActivityCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this,permission))
                return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_ASK_PERMISSIONS) {
            // Fill with results
            for (int i = 0; i < permissions.length; i++)
                perms.put(permissions[i], grantResults[i]);
            // Check for ACCESS_FINE_LOCATION
            Gota.onPermissionSets.OnPermissionsBack(new GoaResponse(perms));

        }
    }




}
