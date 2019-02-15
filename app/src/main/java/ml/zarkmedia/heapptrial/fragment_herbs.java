package ml.zarkmedia.heapptrial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class fragment_herbs extends Fragment {
View v;
private RecyclerView myrecyclerView;
private List<herb> lstherb;

    public fragment_herbs() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_herbs,container,false);
        myrecyclerView=(RecyclerView)v.findViewById(R.id.herb_recyclerview);
        RecyclerviewAdopter recyclerAdopter=new RecyclerviewAdopter(getContext(),lstherb);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerAdopter);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstherb=new ArrayList<>();
        lstherb.add(new herb("Thylem","Ance, Cough, blood presure", R.drawable.thyme));
        lstherb.add(new herb("Stinging Nettles","Detoxifier, RBC stimuli", R.drawable.stingingnettles));
        lstherb.add(new herb("Parsely","Borne&immune health", R.drawable.parsley));
        lstherb.add(new herb("Oregano","Urinary infections,cough", R.drawable.oregano));
        lstherb.add(new herb("Mint","Stomach upsets & nosal congestion", R.drawable.mint));
        lstherb.add(new herb("Holy Basil","Fever, Bronchits, Asthma", R.drawable.holybasil));
        lstherb.add(new herb("Dandelion"," Bone and joint health", R.drawable.dandelion));
        lstherb.add(new herb("Cilatro","colon cancer & imflammation", R.drawable.cilantro));
        lstherb.add(new herb("Catnip","Intesitinal cramps & digestion", R.drawable.catnip));
        lstherb.add(new herb("Bonest","Flu, colds, fevers, migraines", R.drawable.boneset));
        lstherb.add(new herb("Thylem","Ance, Cough, blood presure", R.drawable.thyme));
        lstherb.add(new herb("Stinging Nettles","Detoxifier, RBC stimulator", R.drawable.stingingnettles));
        lstherb.add(new herb("Parsely","Borne & immune health", R.drawable.parsley));
        lstherb.add(new herb("Oregano","Urinary tract infections,cough", R.drawable.oregano));
        lstherb.add(new herb("Mint","Stomach upsets and nosal congestion", R.drawable.mint));
    }
}
