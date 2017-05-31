package com.dell.juliana.filme.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dell.juliana.filme.CategoriaDetailsActivity;
import com.dell.juliana.filme.R;
import com.dell.juliana.filme.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    public List<Categoria> categorias = new ArrayList<Categoria>();
    public ArrayAdapter<Categoria> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);

        ListView lvCategorias = (ListView) view.findViewById(R.id.lv_categorias);

        arrayAdapter = new ArrayAdapter<Categoria>(getActivity(),android.R.layout.simple_list_item_1, categorias);
        lvCategorias.setAdapter(arrayAdapter);

        lvCategorias
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getActivity(), CategoriaDetailsActivity.class);
                startActivity(it);
            }
        });

        return view;

    }
}
