package net.alhazmy13.libary;

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
    public static OnPermissionSetListener onPermissionSets;
    protected static   List<String> permissions;


    public Gota(Context context){
        this.context=context;
        permissions=new ArrayList<>();

    }

    public void checkPermission(String[] permissions,OnPermissionSetListener listen) {
        onPermissionSets=listen;
        Gota.permissions=Arrays.asList(permissions);
        context.startActivity(new Intent(context,GotaActivity.class));

    }

    public interface OnPermissionSetListener{
        void OnPermissionsBack(GoaResponse goaResponse);
    }



}
