package com.obijuan.kramerCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class KramerCalcActivity extends Activity {

    private EditText tv11;
    private EditText tv12;
    private EditText tv13;

    private EditText tv21;
    private EditText tv22;
    private EditText tv23;

    private EditText tv31;
    private EditText tv32;
    private EditText tv33;


    private TextView rTv;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /**
         * Binding UI components to variables
         */
        tv11 = (EditText) findViewById(R.id.tv11);
        tv12 = (EditText) findViewById(R.id.tv12);
        tv13 = (EditText) findViewById(R.id.tv13);

        tv21 = (EditText) findViewById(R.id.tv21);
        tv22 = (EditText) findViewById(R.id.tv22);
        tv23 = (EditText) findViewById(R.id.tv23);

        tv31 = (EditText) findViewById(R.id.tv31);
        tv32 = (EditText) findViewById(R.id.tv32);
        tv33 = (EditText)findViewById(R.id.tv33);

        rTv = (TextView) findViewById(R.id.resVal);
        final Button rBtn = (Button) findViewById(R.id.resBtn);

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularDeterminante();
            }
        });


    }

    private void calcularDeterminante(){

        BigDecimal a11 = new BigDecimal(tv11.getText().toString());
        BigDecimal a12 = new BigDecimal(tv12.getText().toString());
        BigDecimal a13 = new BigDecimal(tv13.getText().toString());

        BigDecimal a21 = new BigDecimal(tv21.getText().toString());
        BigDecimal a22 = new BigDecimal(tv22.getText().toString());
        BigDecimal a23 = new BigDecimal(tv23.getText().toString());

        BigDecimal a31 = new BigDecimal(tv31.getText().toString());
        BigDecimal a32 = new BigDecimal(tv32.getText().toString());
        BigDecimal a33 = new BigDecimal(tv33.getText().toString());

        BigDecimal x = (
                a11.multiply(a22).multiply(a33)
                .add(
                        a12.multiply(a23).multiply(a31)
                )
                .add(
                        a13.multiply(a21).multiply(a32)
                )
        );

        BigDecimal y = (
                        new BigDecimal("-1").multiply(a31.multiply(a22).multiply(a13))
                        .subtract(
                                a32.multiply(a23).multiply(a11)
                        )
                        .subtract(
                                a33.multiply(a21).multiply(a12)
                        )
        );

        rTv.setText(x.add(y).toString());

    }
}
