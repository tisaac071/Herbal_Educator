package ml.zarkmedia.heapptrial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView=itemView;
        //item click
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  mClickListerner.onItemClick(view, getAdapterPosition());
              }
          });

          //item longclick
       itemView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View view) {
               mClickListerner.onItemLongClick(view, getAdapterPosition());
               return false;
           }
       });
    }


    public  void setDetails(Context ctx, String title, String image, String description){
        TextView mTitleview=mView.findViewById(R.id.rtitleTv);
        TextView mDetailTv= mView.findViewById(R.id.rdescriptionTv);
        ImageView mImageView=mView.findViewById(R.id.rImageView);


        //set the details
        mTitleview.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageView);

    }

    private ViewHolder.clickListener mClickListerner;

    //interface to send callbacks
   public interface clickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
   }
   public  void setonClickListener(ViewHolder.clickListener clickListener){
mClickListerner=clickListener;
   }

}
