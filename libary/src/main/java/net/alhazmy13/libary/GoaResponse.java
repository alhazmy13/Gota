package net.alhazmy13.libary;

import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alhazmy13 on 12/6/15.
 */
public class GoaResponse {
    private Map<String,Integer> perms;

    protected GoaResponse(Map<String, Integer> perms){
        this.perms=perms;
    }

    // TODO: 12/8/15 Optimize this
    public String[] deniedPermissions(){
        List<String> list=new ArrayList();
        for(int i=0;i<perms.size();i++){
            if(perms.get(Gota.permissions.get(i))== PackageManager.PERMISSION_DENIED)
                list.add(Gota.permissions.get(i));
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] grantedPermissions(){
        List<String> list=new ArrayList();
        for(int i=0;i<perms.size();i++){
            if(perms.get(Gota.permissions.get(i))== PackageManager.PERMISSION_GRANTED)
                list.add(Gota.permissions.get(i));
        }
        return list.toArray(new String[list.size()]);
    }

    public boolean isAllGranted(){
        int count=0;
        for(int i=0;i<perms.size();i++){
            if(perms.get(Gota.permissions.get(i))== PackageManager.PERMISSION_GRANTED)
                count++;
        }
        return count==perms.size();

    }

    public boolean isAllDenied(){
        int count=0;
        for(int i=0;i<perms.size();i++){
            if(perms.get(Gota.permissions.get(i))== PackageManager.PERMISSION_DENIED)
                count++;
        }
        return count==perms.size();

    }

    public boolean hasDeniedPermission(){
        for(int i=0;i<perms.size();i++){
            if(perms.get(Gota.permissions.get(i))== PackageManager.PERMISSION_DENIED)
                return true;
        }
        return false;
    }

    public boolean isGranted(String permission){
        return (perms.get(permission) == PackageManager.PERMISSION_GRANTED);
    }
    public boolean isDenied(String permission){
        return (perms.get(permission) == PackageManager.PERMISSION_DENIED);
    }

}
