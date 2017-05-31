package com.dell.juliana.filme.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.dell.juliana.filme.FormFilmeActivity;
import com.dell.juliana.filme.R;
import com.dell.juliana.filme.dao.FilmeDAO;
import com.dell.juliana.filme.model.Filme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 11/05/17.
 */

public class FilmeListFragment extends Fragment {



    List<Filme> filmes = new ArrayList<Filme>();
    private ArrayAdapter<String> adapter;
    private ListView lvFilmes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filme_list, container, false );
        //Pegar Referência  do ListView e Button
        lvFilmes = (ListView) view.findViewById(R.id.lv_filmes);
        Button btAdiciona = (Button) view.findViewById(R.id.bt_adiciona);
        final Button btRemove = (Button) view.findViewById(R.id.bt_remove);

        //Popular a Listagem
        /*adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,students);
        lvFilmes.setAdapter(adapter); */

        loadFilmes();

        lvFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //loadFilmeForm(filmes.get(position));

            }
        });

        //Adicionar comportamento para o botão adiciona.
        btAdiciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isLandScape()) {
                    loadFilmeForm(null);
                } else {
                    Intent it = new Intent(getActivity(), FormFilmeActivity.class);
                    startActivity(it);
                }
                //Adicionar comportamento para o botão remover
                btRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (isLandScape()) {
                            loadFilmeForm(null);
                        } else {
                            Intent it = new Intent(getActivity(), FormFilmeActivity.class);
                            startActivity(it);
                        }
                    }
                });

            }

            public boolean isLandScape() {
                Configuration configuration = getResources().getConfiguration();
                if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
                    return true;
                return false;
            }

            private void loadFilmeForm(Filme filme) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction tx = manager.beginTransaction();
                Fragment fragment = new FilmeFormFragment();
                if (filme != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("filme", filme);
                    fragment.setArguments(bundle);
                }
                tx.replace(R.id.fragment_filme_form, fragment);
                tx.addToBackStack(null);
                tx.commit();
            }

            public void loadFilmes() {

                FilmeDAO dao = new FilmeDAO(getActivity());
                filmes = dao.getAllFilmes();

                List<String> filmesTitulos = new ArrayList<String>();

                for (Filme filme : filmes) {
                    filmesTitulos.add(filme.getTitulo());
                }

                adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, filmesTitulos);
                lvFilmes.setAdapter(adapter);
            }


            @Override
            public void onStart() {
                return;
                loadFilmes();
            }
        });
        return view;
    }

    public void loadFilmes() {
    }
}



