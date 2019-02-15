package ml.zarkmedia.heapptrial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PostDetailActivity extends AppCompatActivity {
TextView mTittle, mDetail;
ImageView mImageVie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);


        //action bar
        ActionBar action=getSupportActionBar();
        //title of gthe action bar
        action.setTitle("Company Deatails");

        //setting the back button
        action.setDisplayHomeAsUpEnabled(true);
        action.setDisplayShowHomeEnabled(true);


        //intitialisation of views
        mTittle=findViewById(R.id.titleTv);
        mDetail=findViewById(R.id.descriptionTv);
        mImageVie=findViewById(R.id.ImageViewTV);

        //get data from the iintent

        byte[] bytes=getIntent().getByteArrayExtra("image");
        String title= getIntent().getStringExtra("title");
        String desc=getIntent().getStringExtra("description");
        Bitmap bmp= BitmapFactory.decodeByteArray(bytes,0,bytes.length);


        //set data to Views
mTittle.setText(title);
mDetail.setText(desc);
mImageVie.setImageBitmap(bmp);

    }
    //handling specific item

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}
