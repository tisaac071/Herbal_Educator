package ml.zarkmedia.heapptrial;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MainActivityUser extends AppCompatActivity {
private TabLayout tabLayout;
private ViewPager viewPager;
private  ViewpageAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

    tabLayout=(TabLayout) findViewById(R.id.tablayout_id);
    viewPager=(ViewPager) findViewById(R.id.viewpage_id);
    adaptor=new ViewpageAdaptor(getSupportFragmentManager());


    //adding fragments
        adaptor.Addfragment(new fragment_herbs(),"Herbs");
        adaptor.Addfragment(new Fragment_herbalist(),"Experts");
      // adaptor.Addfragment(new fragment_advert(),"Adverts");

        viewPager.setAdapter(adaptor);
        tabLayout.setupWithViewPager(viewPager);

        ///remove shaadow from the action bar
        ActionBar actionBar= getSupportActionBar();
        actionBar.setElevation(0);


    }
}
