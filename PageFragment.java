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

import com.dell.juliana.filme.NetflixDetailsActivity;
import com.dell.juliana.filme.R;
import com.dell.juliana.filme.model.Netflix;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    public List<Netflix> netflixs = new ArrayList<Netflix>();
    public ArrayAdapter<Netflix> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);

        ListView lvNetflixs = (ListView) view.findViewById(R.id.lv_netflixs);

        arrayAdapter = new ArrayAdapter<Netflix>(getActivity(),android.R.layout.simple_list_item_1,netflixs);
        lvNetflixs.setAdapter(arrayAdapter);

        lvNetflixs
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getActivity(), NetflixDetailsActivity.class);
                startActivity(it);
            }
        });

        return view;

    }
}
