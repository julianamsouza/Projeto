package com.dell.juliana.filme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dell.juliana.filme.model.Categoria;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by JpBrasil on 11/06/2017.
 */

public class CategoriaAdapterJson extends ArrayAdapter<Categoria> {


    private Context context;
    private ArrayList<Categoria> arrayList;

    public CategoriaAdapterJson(Context cont, ArrayList<Categoria> lista) {
        super(cont, 0, lista);
        this.context = cont;
        this.arrayList = lista;
    }


    /**
     * Criando uma View para cada Item
     * Vai devolver nossa view personalizada
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * Vai pegar uma posiçãpo de qual o objeto que esta buscando
         * Pegando o item da lista, na posição que o getView for chamado
         */

        Categoria categoriaPosicao = this.arrayList.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.fragment_detalhe_filme, null);


        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        titulo.setText(categoriaPosicao.getTitulo());

        TextView tipo = (TextView) convertView.findViewById(R.id.tipo);
        tipo.setText(categoriaPosicao.getTipo());

        TextView sinopse = (TextView) convertView.findViewById(R.id.sinopse);
        sinopse.setText(categoriaPosicao.getSinopse());

        ImageView img = (ImageView) convertView.findViewById(R.id.foto);
        Picasso.with(context).load(categoriaPosicao.getUrlFoto()).into(img);


        return convertView;
    }
}


/**
 * Retorna a quantidade de itens existentes na lista
 * <p>
 * Devolvendo o item da lista pela posição, ele quer saber um item a partir de uma posição
 * <p>
 * Devolvendo o id do item da lista. Esse método espera saber qual é o id do objeto que está sendo buscado
 * /*
 */
   /* @Override
    public int getCount() {
        return mJogos.size();
    }*/

/**
 * Devolvendo o item da lista pela posição, ele quer saber um item a partir de uma posição
 */
   /* @Override
    public Object getItem(int position) {
        return mJogos.get(position);
    }*/

/**
 * Devolvendo o id do item da lista. Esse método espera saber qual é o id do objeto que está sendo buscado
 /*  *//*
    @Override
    public long getItemId(int position) {
        return 0;
    }*/