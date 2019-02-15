package ml.zarkmedia.heapptrial;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewpageAdaptor extends FragmentPagerAdapter {
   private final List<Fragment> lstFragment=new ArrayList<>();
   private final List<String> lstTitles= new ArrayList<>();


    public ViewpageAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int Position) {
        return lstFragment.get(Position);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int Position) {
        return lstTitles.get(Position);
    }

    public void Addfragment(Fragment fragment,String title){
        lstFragment.add(fragment);
        lstTitles.add(title);
    }
}
