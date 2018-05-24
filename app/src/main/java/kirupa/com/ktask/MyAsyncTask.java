package kirupa.com.ktask;

import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;

/**
 * Created by kirupa on 17/4/18.
 */


/**
 <arg1,arg2,arg3>
 arg1(String)=>doInBackground using
 arg2(Integer)=>onProgressUpdate using
 arg3(String)=>onPostExecute using*/
public class MyAsyncTask extends AsyncTask<String,Integer,String> {


    String TAG="MyAsyncTask";

    public Interface_Response interface_response = null;

    public MyAsyncTask(Interface_Response delegate){
        this.interface_response = delegate;
    }
    protected void onPreExecute(){
        Log.d(TAG, "onPreExecute:: "+ Looper.myLooper().getThread().getName());

    }
    @Override
    protected String doInBackground(String... strings) {
//        Log.d(TAG, "doInBackground ::"+ Looper.myLooper().getThread().getName());

        Log.d(TAG,"doInBackground String::"+strings);
        String mystring=strings[0];
        String mystring1=strings[1];

        Log.d(TAG,"doInBackground mystring::"+mystring);
        Log.d(TAG,"doInBackground mystring1::"+mystring1);

        int i=0;

        for(i=0;i<5;i++){
            publishProgress(i);

        }
//        publishProgress(i);
        return "very good";
    }
    protected void onProgressUpdate(Integer...integers){
        Log.d(TAG,"onProgressUpdate integers::"+integers[0].toString());
        Log.d(TAG, "onProgressUpdate ::"+ Looper.myLooper().getThread().getName());

    }
    @Override
    protected void onPostExecute(String result){
//         super.onPostExecute(result);
        Log.d(TAG, "onPostExecute:: "+ Looper.myLooper().getThread().getName());

        Log.d(TAG,"onPostExecute result::"+result);
        interface_response.getResult(result);
    }
}
