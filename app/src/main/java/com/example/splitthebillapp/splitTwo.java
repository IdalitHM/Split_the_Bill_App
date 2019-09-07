package com.example.splitthebillapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class splitTwo extends AppCompatActivity {
    double tip = 0.18;
    double totalBill;
    int numberOfPeople;
    double subTotal;
    double totalSplit;
    String groupService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_two);
        final EditText bill = (EditText)findViewById(R.id.txtBill);
        final EditText people = (EditText)findViewById(R.id.txtPeople);
        final Spinner group = (Spinner)findViewById(R.id.txtService);
        Button cost = (Button)findViewById(R.id.btnCalculate);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View view) {
                totalBill = Double.parseDouble(bill.getText().toString());
                numberOfPeople = Integer.parseInt(people.getText().toString());
                subTotal = totalBill * tip;
                totalSplit = (totalBill + subTotal) / numberOfPeople;
                groupService = group.getSelectedItem().toString();
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText("The total payment due per person is " +currency.format(totalSplit));

            }
        });

    }

}
