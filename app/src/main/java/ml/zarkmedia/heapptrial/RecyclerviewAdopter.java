package ml.zarkmedia.heapptrial;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerviewAdopter extends RecyclerView.Adapter<RecyclerviewAdopter.myViewholder> {
    Context mcontext;
     List<herb> mdata;
    Dialog mydialog;
    public RecyclerviewAdopter(Context mcontext, List<herb> mdata) {
       //changed stuff with m
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v= LayoutInflater.from(mcontext).inflate(R.layout.item_herb,parent, false);
        final myViewholder vHolder=new myViewholder(v);


        mydialog=new Dialog(mcontext);
        mydialog.setContentView(R.layout.dialog_herb);
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        vHolder.item_herb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_name_tv =(TextView) mydialog.findViewById(R.id.dialog_name_id);
                TextView dialog_disease_tv =(TextView) mydialog.findViewById(R.id.dialog_disease);
                ImageView dialog_herb_img=(ImageView) mydialog.findViewById(R.id.image_herb_id);

                dialog_name_tv.setText(mdata.get(vHolder.getAdapterPosition()).getName());
                dialog_disease_tv.setText(mdata.get(vHolder.getAdapterPosition()).getDisease());
                dialog_herb_img.setImageResource(mdata.get(vHolder.getAdapterPosition()).getPhoto());
                //making a toast
                //Toast.makeText(mcontext, "Test Click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

                mydialog.show();
            }
        });


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder myViewholder, int posittion) {
        myViewholder.tv_name.setText(mdata.get(posittion).getName());
        myViewholder.tv_disease.setText(mdata.get(posittion).getDisease());
        myViewholder.img.setImageResource(mdata.get(posittion).getPhoto());

    }

    @Override
    public int getItemCount() {

        return mdata.size();
    }

    //public static class myViewholder extends RecyclerView.Adapter<RecyclerviewAdopter.myViewholder>
public static class myViewholder extends RecyclerView.ViewHolder{
        private LinearLayout item_herb;
        private TextView tv_name;
        private TextView tv_disease;
        private ImageView img;


    public myViewholder(@NonNull View itemView) {
        super(itemView);

        item_herb=(LinearLayout)itemView.findViewById(R.id.herb_item_id);
        tv_name=(TextView)itemView.findViewById(R.id.herb_name);
        tv_disease=(TextView) itemView.findViewById(R.id.diseases_name);
        img=(ImageView) itemView.findViewById(R.id.img_herb);
    }
}
}
