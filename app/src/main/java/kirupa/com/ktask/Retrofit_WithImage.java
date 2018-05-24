package kirupa.com.ktask;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Retrofit_WithImage extends AppCompatActivity {
    RecyclerView recyclerView;
    List<UserListResponse_withImage.ActorsBean> userListResponseDataWithImage;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_retrofit__with_image);
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            getUserListData(); // call a method in which we have implement our GET type web API
        }

    private void getUserListData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(Retrofit_WithImage.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

//        Call<UserListResponse_withImage> routeapiCall = API_SERVICE.ManagerLogin(strPhone);

        (Api.getClient().getUsersListWithImage()).enqueue(new Callback<UserListResponse_withImage>() {
            @Override
            public void onResponse(Call<UserListResponse_withImage> call, Response<UserListResponse_withImage> response) {
                Log.d("responseGET", String.valueOf(response.body().getActors()));
                progressDialog.dismiss(); //dismiss progress dialog
                userListResponseDataWithImage = response.body().getActors();

                setDataInRecyclerView();
            }

            @Override
            public void onFailure(Call<UserListResponse_withImage> call, Throwable t) {

            }


        });
    }

    private void setDataInRecyclerView() {
        // set a LinearLayoutManager with default vertical orientation
        GridLayoutManager linearLayoutManager= new GridLayoutManager(Retrofit_WithImage.this,2);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Retrofit_WithImage.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of UsersAdapter to send the reference and data to Adapter
        UserAdapterWithImage userAdapterWithImage  = new UserAdapterWithImage(Retrofit_WithImage.this, userListResponseDataWithImage);
        recyclerView.setAdapter(userAdapterWithImage); // set the Adapter to RecyclerView
    }
}
