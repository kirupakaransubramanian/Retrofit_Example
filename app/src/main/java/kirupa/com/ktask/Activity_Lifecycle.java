package kirupa.com.ktask;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class Activity_Lifecycle extends AppCompatActivity implements Interface_Response {

    String TAG="Activity_Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alifecycle);

        Log.d(TAG,"onCreate invoked");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        new MyAsyncTask(this).execute("Kirupa","Karan");

        //Step 1: Defing object of HashMap Class

        HashMap<Integer,String> HashMap=new HashMap<Integer,String>();

//Step 2: Adding Key Value pair

        HashMap.put(1001,"India");

        HashMap.put(1002,"Canada");

        HashMap.put(1003,"Australia");

        System.out.println(" All the key value pairs " + HashMap);

//Step 3: Displaying key value pairs using for loop

        for(Map.Entry map  :  HashMap.entrySet() )

        {

//Step 4: Using getKey and getValue methods to retrieve key and corresponding value

            System.out.println(map.getKey()+" "+map.getValue());

        }

        Singleton tmp = Singleton.getInstance( );
        tmp.demoMethod( );
        tmp.demoMethod1( );
        Log.d(TAG,"kkk:::"+tmp.kkk);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                startActivity(new Intent(Activity_Lifecycle.this,Async.class));
//                 finish();
//                new MyAsyncTask(this).execute();
                Intent myIntent = new Intent(Activity_Lifecycle.this, Activity3.class);
                myIntent.putExtra("intValue", 125);
                myIntent.putExtra("stringValue", "kirupa");
                myIntent.putExtra("booleanValue", true);
                startActivity(myIntent);


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy invoked");
    }

    @Override
    public void getResult(String result) {
        Log.d(TAG,"getResult::"+result);

    }
}
