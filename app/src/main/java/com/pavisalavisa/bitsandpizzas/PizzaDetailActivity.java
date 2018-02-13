package com.pavisalavisa.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PizzaDetailActivity extends Activity {

    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_PIZZANO="pizzaNo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //enable the up button
        getActionBar().setDisplayHomeAsUpEnabled(true);

        displayPizzaDetails();

    }

    private void displayPizzaDetails(){
        int pizzaNo=(Integer)getIntent().getExtras().get(EXTRA_PIZZANO);
        setPizzaText(pizzaNo);
        setPizzaImage(pizzaNo);
    }

    private void setPizzaText(int pizzaNo){
        String pizzaName=Pizza.pizzas[pizzaNo].getName();
        TextView textView=(TextView)findViewById(R.id.pizza_text);
        textView.setText(pizzaName);
    }
    private void setPizzaImage(int pizzaNo){
        int pizzaImage=Pizza.pizzas[pizzaNo].getImageResourceID();
        ImageView imageView=(ImageView)findViewById(R.id.pizza_image);
        imageView.setImageDrawable(getResources().getDrawable(pizzaImage));
        imageView.setContentDescription(Pizza.pizzas[pizzaNo].getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        sharePizzaInfo(menu);
        return true;
    }

    private void sharePizzaInfo(Menu menu){
        TextView textView=(TextView)findViewById(R.id.pizza_text);
        CharSequence pizzaName=textView.getText();

        MenuItem menuItem=menu.findItem(R.id.action_share);
        shareActionProvider=(ShareActionProvider)menuItem.getActionProvider();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,pizzaName);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_create_order:
                Intent intent =new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
