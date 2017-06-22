package com.dell.juliana.filme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dell.juliana.filme.fragments.FormFilmeFragments;
import com.dell.juliana.filme.fragments.ListFilmesFragments;



public class ListFilmesActivity extends AppCompatActivity implements FormFilmeFragments.OnRefreshFormOK{

    ListFilmesFragments fragmentList;
    private Toolbar toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filme);
        fragmentList = (ListFilmesFragments) getSupportFragmentManager().findFragmentById(R.id.fragmentList);
        toolbarLayout = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbarLayout);//Setando a toolbar
    }

    @Override
    public void refresh() {
        fragmentList.loadFilmes();
    }

    //Para fazer algo na toolbar usamos onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();//Criando variável que pega um menu inflater
        inflater.inflate(R.menu.menu_toolbar, menu);//referenciando o menu que criamos
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//Aqui vai detectar o menu
        Intent it;
        switch (item.getItemId()){
            case R.id.botaoMap:
                it = new Intent(this, MapsActivity.class);
                startActivity(it);
                break;
            case R.id.btnPager:
                it = new Intent(this, ViewPagerFilmeActivity.class);
                startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
