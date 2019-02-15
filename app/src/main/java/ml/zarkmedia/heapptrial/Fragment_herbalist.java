package ml.zarkmedia.heapptrial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static android.widget.Toast.LENGTH_SHORT;

public class Fragment_herbalist extends Fragment {

    private RecyclerView myrecyclerview;
    DatabaseReference mref;
    FirebaseDatabase mFirebaseDatabase;
    View v;
    private RecyclerView mPeopleRV;
    private FirebaseRecyclerAdapter<model, ViewHolder> mPeopleRVAdapter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.herbalist_fragment, container, false);

        mPeopleRV = v.findViewById(R.id.RecyClerView);

        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("Data");
        Query personsQuery = personsRef.orderByKey();

        mPeopleRV.hasFixedSize();
        mPeopleRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<model>().setQuery(personsQuery, model.class).build();

        mPeopleRVAdapter = new FirebaseRecyclerAdapter<model, ViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(ViewHolder holder, int position, model model) {
                holder.setDetails(getActivity(), model.getTitle(), model.getImage(), model.getDescription());

            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row, parent, false);

                return new ViewHolder(view);
            }
        };

        mPeopleRV.setAdapter(mPeopleRVAdapter);
        return v;
    }


    //search data
    private void  firebaseSearch(String Searchnext){
       // DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("Data");
       // Query personsQuery = personsRef.orderByKey();
        Query firebasesearchQuery= mref.orderByChild("title").startAt(Searchnext).endAt(Searchnext + "\uf8ff");
   //FirebaseRecyclerAdapter<model, ViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<model, ViewHolder>(model.class,R.layout.row,ViewHolder.class,mref) {
        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<model>().setQuery(firebasesearchQuery, model.class).build();
//just copied
        mPeopleRVAdapter = new FirebaseRecyclerAdapter<model, ViewHolder>(personsOptions) {
       @Override
       protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull model model) {
           holder.setDetails(getActivity(), model.getTitle(), model.getImage(), model.getDescription());
       }

       @NonNull
       @Override
       public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
          // ViewHolder viewHolder=super.onCreateViewHolder(viewGroup,i);
           View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
//------ new deatils from tutorial 3

           ViewHolder viewHolder=/*super.*/onCreateViewHolder(viewGroup, i);
           viewHolder.setonClickListener(new ViewHolder.clickListener() {
               @Override
               public void onItemClick(View view, int position) {
               //views
                   TextView mtitleTV=view.findViewById(R.id.rtitleTv);
                   TextView mDesTV=view.findViewById(R.id.rdescriptionTv);
                   ImageView mImageView=view.findViewById(R.id.rImageView);

                   //get data from them views
                   String mTitle=mtitleTV.getText().toString();
                   String mDesc=mDesTV.getText().toString();
                   Drawable mDrwawable=mImageView.getDrawable();
                   Bitmap mbitmap=((BitmapDrawable)mDrwawable).getBitmap();


                   //passiing the data to the new activity

                   Intent intent= new Intent(view.getContext(),PostDetailActivity.class );
                  // ByteArrayInputStream stream=new ByteArrayInputStream();
                   ByteArrayOutputStream stream= new ByteArrayOutputStream();
                   mbitmap.compress(Bitmap.CompressFormat.PNG, 100,stream);
                   byte[] bytes=stream.toByteArray();
                   intent.putExtra("image",bytes);
                   intent.putExtra("title", mTitle);
                   intent.putExtra("description", mDesc);
                   startActivity(intent);

               }

               @Override
               public void onItemLongClick(View view, int position) {

                   //needs implimentation of the long click
               }
           });
           //return  super.onCreateViewHolder(viewGroup, i);
           return new ViewHolder(view);
       }

   };
        myrecyclerview.setAdapter(mPeopleRVAdapter);


    }
    @Override
    public void onStart() {
        super.onStart();


        /*setHasOptionsMenu(true);*/
        mPeopleRVAdapter.startListening();
    }



    //on create options method

/*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                firebaseSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                //filter as you type
                firebaseSearch(s);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
//method for the selected options
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        //handling other action bar items here
        if (id==R.id.aaction_setting){
            //intent to the other activioty
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter.stopListening();
    }


}
