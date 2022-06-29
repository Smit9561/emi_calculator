package com.monstercalsimp.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    EditText amount_edt,int_edt,month_edt;
    Button emi;
    TextView emi_txt,Total_txt,extra_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount_edt=findViewById(R.id.principal);
        int_edt=findViewById(R.id.interest);
        month_edt=findViewById(R.id.month_edt);
        emi=findViewById(R.id.emi);

        emi_txt=findViewById(R.id.emi_txt);
        Total_txt=findViewById(R.id.Total_txt);
        extra_txt=findViewById(R.id.extra_txt);

        emi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                double amt= Double.parseDouble(amount_edt.getText().toString());
                double rate= Double.parseDouble(int_edt.getText().toString());
                double month= Double.parseDouble(month_edt.getText().toString());

                if(amount_edt.getText().toString().isEmpty()){
                    amount_edt.setText(" Enter a amount");
                } else if(int_edt.getText().toString().isEmpty()){
                    int_edt.setText("Enter a interest");
                } else if (month_edt.getText().toString().isEmpty()){
                    month_edt.setText("Enter a month");
                }else {

                    double r = rate /(12*100);

                    double cal=1;

                    for(int i=0 ; i<month;i++){
                        cal *=(1+r);
                    }

                    double ans = amt * r *(cal/(cal-1));


                    emi_txt.setText("EMI = "+ans);
                    Total_txt.setText("Total = "+(ans*month));
                    extra_txt.setText("Interest = "+(amt*month-amt));



                }

            }
        });


    }
}