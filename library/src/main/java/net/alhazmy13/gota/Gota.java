package net.alhazmy13.gota;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Alhazmy13 on 11/24/15.
 * Gota
 */
public class Gota {

    private WeakReference<Activity> context;
    private int requestId;
    /**
     * The Permissions.
     */
    protected ArrayList permissions;
    /**
     * The constant listener.
     */
    static OnRequestPermissionsBack listener;


    private Gota(Activity activity) {
        this.context = new WeakReference<>(activity);

    }


    /**
     * Instantiates a new Builder.
     *
     * @param activity the activity
     */
    public static Gota Builder(@NonNull Activity activity) {
        return new Gota(activity);
    }


    /**
     * With permissions gota . builder.
     *
     * @param permissions the permissions
     * @return the gota . builder
     */
    public Gota withPermissions(@NonNull String... permissions) {
        this.permissions = new ArrayList<>(Arrays.asList(permissions));
        return this;
    }

    /**
     * Sets listener.
     *
     * @param listener the listener
     * @return the listener
     */
    public Gota setListener(OnRequestPermissionsBack listener) {
        this.listener = listener;
        return this;
    }

    /**
     * Request id gota . builder.
     *
     * @param requestId the request id
     * @return the gota . builder
     */
    public Gota requestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Check gota.
     *
     * @return the gota
     */
    public Gota check() {
        Intent callingIntent = GotaActivity.getCallingIntent(context.get(), permissions, requestId);
        context.get().startActivity(callingIntent);
        return this;
    }

    /**
     * The interface On request permissions back.
     */
    public interface OnRequestPermissionsBack {
        /**
         * On request back.
         *
         * @param gotaResponse the gota response
         */
        void onRequestBack(int requestId, @NonNull GotaResponse gotaResponse);
    }


}
