package com.pavisalavisa.bitsandpizzas;

/**
 * Created by krist on 12.2.2018..
 */

public class Pizza {
    private String name;
    private int imageResourceID;

    public static final Pizza[] pizzas={
            new Pizza("Diavolo",R.drawable.diavolo),
            new Pizza("Funghi",R.drawable.funghi)
    };

    public Pizza(String name,int imageResourceID){
        this.name=name;
        this.imageResourceID=imageResourceID;
    }

    public String getName(){
        return name;
    }

    public int getImageResourceID(){
        return imageResourceID;
    }
}
