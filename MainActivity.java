package com.dell.juliana.filme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dell.juliana.filme.fragments.FilmeFormFragment;
import com.dell.juliana.filme.fragments.FilmeListFragment;

public class MainActivity extends AppCompatActivity implements FilmeFormFragment.OnRefreshFormOK {

    FilmeListFragment fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentList = (FilmeListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_filme_list);

    }


    @Override
    public void refresh() {
        fragmentList.loadFilmes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_visualize:
                Intent it = new Intent(this, ViewpagerActivity.class);
                startActivity(it);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

