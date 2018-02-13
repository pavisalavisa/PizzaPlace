package com.pavisalavisa.bitsandpizzas;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PastaMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RecyclerView pastaRecycler=(RecyclerView)inflater.inflate(R.layout.fragment_pasta_material,container,false);

        String [] pastaNames=new String[Pasta.pastas.length];
        int [] pastaImages=new int[Pasta.pastas.length];
        for(int i=0;i<pastaNames.length;i++){
            pastaNames[i]=Pasta.pastas[i].getName();
            pastaImages[i]=Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImageAdapter adapter=new CaptionedImageAdapter(pastaNames,pastaImages);
        pastaRecycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        pastaRecycler.setLayoutManager(layoutManager);
        return pastaRecycler;


    }

}