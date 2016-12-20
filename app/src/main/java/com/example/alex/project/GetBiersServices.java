package com.example.alex.project;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.nfc.Tag;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetBiersServices extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_GET_ALL_BIERS = "com.example.alex.project.action.FOO";
    //private static final String ACTION_BAZ = "com.example.alex.project.action.BAZ";

    // TODO: Rename parameters
    //private static final String EXTRA_PARAM1 = "com.example.alex.project.extra.PARAM1";
   // private static final String EXTRA_PARAM2 = "com.example.alex.project.extra.PARAM2";

    public GetBiersServices() {
        super("GetBiersServices");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionGET_ALL_BIERS(Context context) {
        Intent intent = new Intent(context, GetBiersServices.class);
        intent.setAction(ACTION_GET_ALL_BIERS);
       // intent.putExtra();
        //intent.putExtra();
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_GET_ALL_BIERS.equals(action)) {

                handleActionBiers();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBiers() {
        // TODO: Handle action Foo
        Log.i("tags", "handleActionGET_ALL_BIERS: ");
        Log.d("tags","thread service name:" + Thread.currentThread().getName());
        URL url = null;

        try {
            url = new URL("http://binouze.fabrigli.fr/bieres.json");
            HttpURLConnection conn =(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK ==conn.getResponseCode()) {
                copyInputStreamToFile (conn.getInputStream(), new File(getCacheDir(),"bieres.json"));
                Log.d("toast","Bieres json download !");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(MainActivity.BIERS_UPDATE));
    }

    private void copyInputStreamToFile (InputStream in,File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[]buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
