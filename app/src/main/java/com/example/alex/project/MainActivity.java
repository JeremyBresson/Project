package com.example.alex.project;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;
    static final int Notification_ID = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_hw = (TextView) findViewById(R.id.tv_date);


        /*Affiche la date du jour*/
        //String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
       // tv_hw.setText(now);



        /*Calendrier*/
        final Calendar calendar = Calendar.getInstance();
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonOnClick();
        /*Fin calendrier*/

        /*Notification*/
        createbouttonNotification();
        /*Fin notification*/

        /*Intent*/
        dialogButtonItent();
        //dialogButtonItentAction();


        /*Service*/
        dialogButtonService ();
        IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(), intentFilter);

        /*LayoutMannager*/
        //android.support.v7.widget.RecyclerView widget_biere = (android.support.v7.widget.RecyclerView)findViewById(R.id.rv_biere);

        //rv.setLayoutMannager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    } /*Ici fin du onCreate pour appel de fonction*/


    /*Bouton calendrier*/
    public void showDialogOnButtonOnClick() {
        Button btn_cal = (Button) findViewById(R.id.btn_calendrier);
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpd, year_x, month_x, day_x);
        return null; /*si id != DIALOG_ID il retourn null*/
    }

    public DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;

            /*Toast.makeText(MainActivity.this,year_x + "/" + month_x + "/" + day_x,Toast.LENGTH_LONG).show();*/
        }
    };
    /*Fin Bouton calendrier*/

    /*notification + Intent3*/

    public void createbouttonNotification () {

        Button btn_test = (Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ajout d'une notification", Toast.LENGTH_LONG).show();
                createNotification();
                /*go intent 3*/
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void createNotification () {
        final NotificationManager mNotification =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder nbuilder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Project")
                .setContentText("Tu viens de testez ton taux d'alcoolémie.");

        mNotification.notify(Notification_ID,nbuilder.build());

    }



    /*ActionBar*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId()) {

            case R.id.toast:
                Toast.makeText(getApplicationContext(),"salut",Toast.LENGTH_LONG).show();
            case R.id.research:
                Toast.makeText(getApplicationContext(), "rechercher", Toast.LENGTH_SHORT).show();
            return true;

            case R.id.calendar:
                Toast.makeText(getApplicationContext(),"calendar",Toast.LENGTH_LONG).show();
                DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);


                final Calendar calendar = Calendar.getInstance();
                year_x = calendar.get(Calendar.YEAR);
                month_x = calendar.get(Calendar.MONTH);
                day_x = calendar.get(Calendar.DAY_OF_MONTH);
                showDialogOnButtonOnClick();

                return true;

            default:
            return super.onOptionsItemSelected(item);
        }
    }
    /*Fin Action Bar*/


    public void dialogButtonItent () {
        Button btn_p1 =(Button)findViewById(R.id.btn_intent);

        btn_p1.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Intent good", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondeActivity.class);
                startActivity(intent);

            }
        });

    }


    /*public void dialogButtonItentAction () {
        ImageView btn_intentA = (ImageView)findViewById(R.id.logo_bp);

        btn_intentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Londre")));
            }
        });


    }*/
    /*Fin intent*/

    /*Début service téléchargement*/

    public void dialogButtonService  () {

        Button btn_service = (Button)findViewById(R.id.btn_serv);
        btn_service.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                createNotification2();
                GetBiersServices.startActionGET_ALL_BIERS(getApplicationContext());
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void createNotification2 () {
        final NotificationManager mNotification =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder nbuilder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Project")
                .setContentText("Téléchargement réussi.");

        mNotification.notify(Notification_ID,nbuilder.build());

    }


    public static final String BIERS_UPDATE = "com.octip.cours.inf4042_11.BIERS_UPDATE";
    public class BierUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("tag",getIntent().getAction());
            Toast.makeText(getApplicationContext(),"Téléchargement",Toast.LENGTH_LONG).show();
        }

    }
    /*
    private class BiersAdapter extends RecyclerView.Adapter<BiersAdapter.BierHolder> {

        class BierHolder extends RecyclerView.ViewHolder{
            private JSONArray biers;


            public BierHolder(View JsonArray) {
                super(JsonArray);
        }
        }

    }
    */

}