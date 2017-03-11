package net.alhazmy13.gota;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alhazmy13 on 12/6/15.
 * Gota
 */
public class GotaResponse {
    private final Map<String, Integer> mPerms;
    private final ArrayList<String> mUserPermission;
    private Activity mActivity;
    private final int requestId;
    /**
     * Instantiates a new Gota response.
     *
     * @param perms    the perms
     * @param userPerm the user perm
     */
    GotaResponse(Map<String, Integer> perms, ArrayList<String> userPerm, Activity activity, int requestId) {
        this.mPerms = perms;
        this.mUserPermission = userPerm;
        this.mActivity = activity;
        this.requestId = requestId;
    }

    /**
     * Denied permissions string [ ].
     *
     * @return the string [ ]
     */
// TODO: 12/8/15 Optimize this
    public String[] deniedPermissions() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < mPerms.size(); i++) {
            if (mPerms.get(mUserPermission.get(i)) == PackageManager.PERMISSION_DENIED)
                list.add(mUserPermission.get(i));
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * Granted permissions string [ ].
     *
     * @return the string [ ]
     */
    public String[] grantedPermissions() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < mPerms.size(); i++) {
            if (mPerms.get(mUserPermission.get(i)) == PackageManager.PERMISSION_GRANTED)
                list.add(mUserPermission.get(i));
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * Is all granted boolean.
     *
     * @return the boolean
     */
    public boolean isAllGranted() {
        int count = 0;
        for (int i = 0; i < mPerms.size(); i++) {
            if (mPerms.get(mUserPermission.get(i)) == PackageManager.PERMISSION_GRANTED)
                count++;
        }
        return count == mPerms.size();

    }

    /**
     * Is all denied boolean.
     *
     * @return the boolean
     */
    public boolean isAllDenied() {
        int count = 0;
        for (int i = 0; i < mPerms.size(); i++) {
            if (mPerms.get(mUserPermission.get(i)) == PackageManager.PERMISSION_DENIED)
                count++;
        }
        return count == mPerms.size();

    }

    /**
     * Has denied permission boolean.
     *
     * @return the boolean
     */
    public boolean hasDeniedPermission() {
        for (int i = 0; i < mPerms.size(); i++) {
            if (mPerms.get(mUserPermission.get(i)) == PackageManager.PERMISSION_DENIED)
                return true;
        }
        return false;
    }



    /**
     * Is on never ask again boolean.
     *
     * @param permission the permission
     * @return the boolean
     */
    @TargetApi(Build.VERSION_CODES.M)
    public boolean isOnNeverAskAgain(String permission) {
        return (!mActivity.shouldShowRequestPermissionRationale(permission));
    }

    /**
     * Is granted boolean.
     *
     * @param permission the permission
     * @return the boolean
     */
    public boolean isGranted(String permission) {
        return mPerms.containsKey(permission) && (mPerms.get(permission) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Is denied boolean.
     *
     * @param permission the permission
     * @return the boolean
     */
    public boolean isDenied(String permission) {
        return (mPerms.get(permission) == PackageManager.PERMISSION_DENIED);
    }



}
