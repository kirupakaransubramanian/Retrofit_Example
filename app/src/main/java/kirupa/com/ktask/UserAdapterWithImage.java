package kirupa.com.ktask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.util.List;

/**
 * Created by kirupa on 5/5/18.
 */

public class UserAdapterWithImage extends RecyclerView.Adapter<UserAdapterWithImage.UsersViewHolder> {

    Context context;
    List<UserListResponse_withImage.ActorsBean> userListResponseData;

    public UserAdapterWithImage(Context context, List<UserListResponse_withImage.ActorsBean> userListResponseData) {
        this.userListResponseData = userListResponseData;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_listitem_with_image, null);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {
        // set the data
         //  Image load using Bitmap
         //  new DownloadImageTask(holder.imageview).execute(userListResponseData.get(position).getImage());

        //Image Load using Picasso
        //Picasso.with(context).load(String.valueOf(userListResponseData.get(position).getImage())).into(holder.imageview);



       //Image load using Glide
        Glide.with(context)
                .load(userListResponseData.get(position).getImage())
                .override(300, 200)
                .into(holder.imageview);


        holder.tvName.setText(userListResponseData.get(position).getName());
        holder.tvDescription.setText(userListResponseData.get(position).getDescription());
        holder.tvDOB.setText("B'day: " + userListResponseData.get(position).getDob());
        holder.tvCountry.setText(userListResponseData.get(position).getCountry());
        holder.tvHeight.setText("Height: " + userListResponseData.get(position).getHeight());
        holder.tvSpouse.setText("Spouse: " + userListResponseData.get(position).getSpouse());
        holder.tvChildren.setText("Children: " + userListResponseData.get(position).getChildren());
//        holder.name.setText("Name: " + userListResponseData.get(position).getName());
//        holder.email.setText("Email: " + userListResponseData.get(position).getEmail());
        // implement setONCLickListtener on itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with user name
                Toast.makeText(context, userListResponseData.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userListResponseData.size(); // size of the list items
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        public ImageView imageview;
        public TextView tvName;
        public TextView tvDescription;
        public TextView tvDOB;
        public TextView tvCountry;
        public TextView tvHeight;
        public TextView tvSpouse;
        public TextView tvChildren;

        public UsersViewHolder(View itemView) {
            super(itemView);

            imageview = (ImageView) itemView.findViewById(R.id.ivImage);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescriptionn);
            tvDOB = (TextView) itemView.findViewById(R.id.tvDateOfBirth);
            tvCountry = (TextView) itemView.findViewById(R.id.tvCountry);
            tvHeight = (TextView) itemView.findViewById(R.id.tvHeight);
            tvSpouse = (TextView) itemView.findViewById(R.id.tvSpouse);
            tvChildren = (TextView) itemView.findViewById(R.id.tvChildren);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}