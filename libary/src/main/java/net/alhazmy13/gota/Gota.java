package net.alhazmy13.gota;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alhazmy13 on 11/24/15.
 */
public class Gota {

    protected static Context context;
    public static OnRequestPermissionsBack onPermissionSets;
    protected static   List<String> permissions;


    public Gota(Context context){
        this.context=context;
        permissions=new ArrayList<>();

    }

    public void checkPermission(String[] permissions,OnRequestPermissionsBack listen) {
        onPermissionSets=listen;
        Gota.permissions=Arrays.asList(permissions);
        context.startActivity(new Intent(context,GotaActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

    }

    public interface OnRequestPermissionsBack{
        void onRequestBack(GotaResponse gotaResponse);
    }



}
