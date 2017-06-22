package com.dell.juliana.filme;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dell.juliana.filme.fragments.PageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JpBrasil on 02/06/2017.
 */

public class PagerAdapterFragments extends FragmentPagerAdapter {

    String[] titulos;
    List<PageFragment> pagers = new ArrayList<PageFragment>();


    public PagerAdapterFragments(FragmentManager fm, String[] titulos) {
        super(fm);
        this.titulos = titulos;
        this.pagers.add(new PageFragment());
        this.pagers.add(new PageFragment());
        this.pagers.add(new PageFragment());
    }

    //Vai retornar um fragment
    @Override
    public Fragment getItem(int position) {
        return pagers.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }
}
