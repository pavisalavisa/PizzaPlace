package com.pavisalavisa.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout=(LinearLayout)inflater.inflate(R.layout.fragment_top,container,false);
        RecyclerView pizzaRecycler=(RecyclerView)layout.findViewById(R.id.top_recycler);

        String[] pizzaNames=setPizzaNames();
        int [] pizzaImages=setPizzaImages();

        CaptionedImageAdapter adapter=new CaptionedImageAdapter(pizzaNames,pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        pizzaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImageAdapter.Listener(){
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO,position);
                getActivity().startActivity(intent);
            }
        });
        return layout;
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
