package com.example.dell.justjava;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        if(quantity==100){
            return;
        }
        Toast.makeText(this,"You can not have more than 100 coffess", Toast.LENGTH_SHORT).show();
        quantity=quantity+1;
        displayQuantity(quantity);

    }

    public void decrement(View view){
        if(quantity==1){
            return;
        }
        Toast.makeText(this,"You can not have less than 1 coffess", Toast.LENGTH_SHORT).show();
        quantity=quantity-1;
        displayQuantity(quantity);

    }
    public void submitOrder(View view){
//        EditText nameField = (EditText)findViewById(R.id.name_field);
//        String value = nameField.getText().toString();
//        int price = calculatePrice();
//        String priceMessage =createOrderSummary(price,value);
//        displayMessage(priceMessage);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geolocation);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }

    public void displayQuantity(int numberOfCoffess){
        TextView quantityTextView =(TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" +numberOfCoffess);
    }

    public void displayMessage(String message){
        TextView orderSummaryTextView =(TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(){
        int price = quantity*5;
        return price;

    }
    private String createOrderSummary(int price, String name){
        String priceMessage ="\nName :" +name;
        priceMessage+= "\nQuantity" +quantity;
        priceMessage+= "\nPrice $" +price;
        priceMessage+= "\nThank You";
        return priceMessage;
    }

}
