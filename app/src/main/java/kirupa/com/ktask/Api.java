package kirupa.com.ktask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kirupa on 4/5/18.
 */

public class Api {
    private static Retrofit retrofit = null;
    public static ApiInterface getClient() {

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
//                    .baseUrl("http://mobileappdatabase.in/")
                    .baseUrl("http://microblogging.wingnity.com/JSONParsingTutorial/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);
        return api; // return the APIInterface object


    }

}