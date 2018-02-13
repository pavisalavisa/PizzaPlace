package com.pavisalavisa.bitsandpizzas;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PizzaMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RecyclerView pizzaRecycler=(RecyclerView)inflater.inflate(R.layout.fragment_pizza_material,container,false);

        String[] pizzaNames=setPizzaNames();
        int [] pizzaImages=setPizzaImages();

        CaptionedImageAdapter adapter=new CaptionedImageAdapter(pizzaNames,pizzaImages);
        pizzaRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImageAdapter.Listener(){

            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO,position);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecycler;
    }

    private String[] setPizzaNames(){
        String[] pizzaNames=new String[Pizza.pizzas.length];
        for(int i=0;i<pizzaNames.length;i++)
            pizzaNames[i]=Pizza.pizzas[i].getName();
        return pizzaNames;
    }
    private int[] setPizzaImages(){
        int [] pizzaImages=new int[Pizza.pizzas.length];
        for(int i=0;i<pizzaImages.length;i++)
            pizzaImages[i]=Pizza.pizzas[i].getImageResourceID();
        return pizzaImages;
    }
}