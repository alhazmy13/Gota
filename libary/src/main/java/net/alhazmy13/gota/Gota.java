package net.alhazmy13.gota;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alhazmy13 on 11/24/15.
 * Gota
 */
public class Gota {

    protected Context context;
    protected static OnRequestPermissionsBack onPermissionSets;
    protected ArrayList<String> permissions;


    public Gota(Context context){
        this.context=context;
        permissions=new ArrayList<>();

    }

    public void checkPermission(String[] permissions,OnRequestPermissionsBack listen) {
        onPermissionSets=listen;
        this.permissions = new ArrayList<>(Arrays.asList(permissions));
        this.context.startActivity(new Intent(context,GotaActivity.class).putStringArrayListExtra("permissions",this.permissions).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

    }

    public interface OnRequestPermissionsBack{
        void onRequestBack(GotaResponse gotaResponse);
    }



}
