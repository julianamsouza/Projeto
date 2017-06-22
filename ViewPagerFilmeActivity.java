package com.dell.juliana.filme;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ViewPagerFilmeActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private Toolbar toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_filme);
        toolbarLayout = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbarLayout);//Setando a toolbar


        /*viewPager = (ViewPager)findViewById(R.id.viewPager);

        //Instanciando PagerAdapterFragments
        PagerAdapterFragments adapterFragments = new PagerAdapterFragments(
                getSupportFragmentManager(), titulos);
        viewPager.setAdapter(adapterFragments);*/

        //Carregando o ViewPager
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        //Carregando as Imagens
        int[] filmes = {R.drawable.cine_tela};
        PagerAdapterImagens imagens = new PagerAdapterImagens(
                getApplication(), filmes);
        viewPager.setAdapter(imagens);


    }
}
