package net.alhazmy13.gota;

import android.app.Activity;
import android.content.Intent;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Alhazmy13 on 11/24/15.
 * Gota
 */
public class Gota {

    private WeakReference<Activity> context;
    /**
     * The Permissions.
     */
    protected ArrayList permissions;
    /**
     * The constant listener.
     */
    static OnRequestPermissionsBack listener;

    private Gota(Builder builder) {
        context = builder.context;
        permissions = new ArrayList<>(Arrays.asList(builder.permissions));
        listener = builder.listener;
        Intent callingIntent = GotaActivity.getCallingIntent(context.get(), permissions,builder.requestId);
        context.get().startActivity(callingIntent);
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
        void onRequestBack(int requestId,GotaResponse gotaResponse);
    }

    /**
     * The type Builder.
     */
    public static class Builder {
        private WeakReference<Activity> context;
        private String[] permissions;
        private int requestId;
        /**
         * The Listener.
         */
        protected OnRequestPermissionsBack listener;

        /**
         * Instantiates a new Builder.
         *
         * @param activity the activity
         */
        public Builder(Activity activity) {
            this.context = new WeakReference<>(activity);
        }


        /**
         * With permissions gota . builder.
         *
         * @param permissions the permissions
         * @return the gota . builder
         */
        public Gota.Builder withPermissions(String... permissions) {
            this.permissions = permissions;
            return this;
        }

        /**
         * Sets listener.
         *
         * @param listener the listener
         * @return the listener
         */
        public Gota.Builder setListener(OnRequestPermissionsBack listener) {
            this.listener = listener;
            return this;
        }

        /**
         * Request id gota . builder.
         *
         * @param requestId the request id
         * @return the gota . builder
         */
        public Gota.Builder requestId(int requestId){
            this.requestId = requestId;
            return this;
        }

        /**
         * Check gota.
         *
         * @return the gota
         */
        public Gota check() {
            return new Gota(this);
        }
    }


}
