package kirupa.com.ktask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class IVY extends AppCompatActivity {

    public Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ivy);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final int random = new Random().nextInt(10000); // [0, 60] + 20 => [20, 80]

        Log.d("IVY","random:::"+ random);

        int randomPIN = (int)(Math.random()*9000)+100000;

        Log.d("IVY","randomPIN:::"+ randomPIN);


        String val = ""+randomPIN;
        sp=(Spinner)findViewById(R.id.sp1);
        ArrayList<String> arrayList=new ArrayList<>();
        String title="chennai@madurai@selam@thanjaoor@tirunelveli";

        String[] kk= title.split("@");
        Log.d("IVY","kk[0]:::"+ kk.length);

        for(int i=0;i<kk.length;i++){
            Log.d("IVY","kk[i]:::"+ kk[i]);

            arrayList.add(kk[i]);
        }

        Log.d("IVY","arraylist:::"+ arrayList.size());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList);
        sp.setAdapter(adapter); // this will set list of values to spinner

       sp.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       } );
//        FloatingActionButton fab = (FloatingActionButton) findViewById(fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
