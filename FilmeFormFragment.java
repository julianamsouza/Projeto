package com.dell.juliana.filme.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dell.juliana.filme.R;
import com.dell.juliana.filme.dao.FilmeDAO;
import com.dell.juliana.filme.model.Filme;

/**
 * Created by root on 12/05/17.
 */

public class FilmeFormFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_filme,container, false);
        //Pegar a referência das Views


        final EditText etTitulo = (EditText) view.findViewById(R.id.et_filme_titulo);
        final EditText etTipo = (EditText) view.findViewById(R.id.et_filme_tipo);
        final EditText etSinopse = (EditText) view.findViewById(R.id.et_filme_sinopse);

        Bundle bundle = getArguments();
        if (bundle != null){
            Filme filme = (Filme) bundle.getSerializable("filme");
            //carregar titulo
            etTitulo.setText(filme.getTitulo());
            etTipo.setText(filme.getTipo());
            etSinopse.setText(filme.getSinopse());
            //carregar tipo
            //carregar sinopse
        }

        Button btSave = (Button) view.findViewById(R.id.bt_save);



        //Setar para botão salvar os dados
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilmeDAO dao = new FilmeDAO(getActivity());
                Filme filme = new Filme();
                filme.setTitulo(etTitulo.getText().toString());
                filme.setTipo(etTipo.getText().toString());
                filme.setSinopse(etSinopse.getText().toString());
                dao.insert(filme);
                OnRefreshFormOK activity = (OnRefreshFormOK) getActivity();
                activity.refresh();
                if (!isLandScape())
                    getActivity().finish();
                Toast.makeText(getActivity(),"Filme inserido com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    public boolean isLandScape(){
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    public interface OnRefreshFormOK{
        public void refresh();
    }

}
