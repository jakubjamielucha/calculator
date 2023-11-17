package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnAC, btnDel, btnPlus, btnMinus, btnDivide, btnMulti, btnEquals, btnDot;

    private TextView textViewResult, textViewHistory;

    private String number = null;

    double firstNumber = 0, lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat myFormatter = new DecimalFormat("#######.######");

    String history, currentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);
        btnEquals = findViewById(R.id.btnEquals);
        btnDot = findViewById(R.id.btnDot);

        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="0";
                textViewHistory.setText(history);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="1";
                textViewHistory.setText(history);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="2";
                textViewHistory.setText(history);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="3";
                textViewHistory.setText(history);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="4";
                textViewHistory.setText(history);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="5";
                textViewHistory.setText(history);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="6";
                textViewHistory.setText(history);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="7";
                textViewHistory.setText(history);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="8";
                textViewHistory.setText(history);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                history+="9";
                textViewHistory.setText(history);
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = number.substring(0,number.length()-1);
                textViewResult.setText(number);
                history = textViewHistory.getText().toString().substring(0,history.length()-1);
                textViewHistory.setText(history);

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+"+");

                if(operator){
                    if(status=="multiplication"){
                        multiply();
                    } else if(status == "division"){
                        divide();
                    } else if(status == "subtraction"){
                        minus();
                    } else{
                        plus();
                    }
                }
                status = "sum";
                operator = false;
                number = null;

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+"-");

                if(operator){
                    if(status=="multiplication"){
                        multiply();
                    } else if(status == "division"){
                        divide();
                    } else if(status == "sum"){
                        plus();
                    } else{
                        minus();
                    }
                }
                status = "subtraction";
                operator = false;
                number = null;

            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+"x");

                if(operator){
                    if(status=="subtraction"){
                        minus();
                    } else if(status == "division"){
                        divide();
                    } else if(status == "sum"){
                        plus();
                    } else{
                        multiply();
                    }
                }
                status = "multiplication";
                operator = false;
                number = null;

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+"/");

                if(operator){
                    if(status=="subtraction"){
                        minus();
                    } else if(status == "multiplication"){
                        multiply();
                    } else if(status == "sum"){
                        plus();
                    } else{
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;

            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(operator) {
                    if (status == "subtraction") {
                        minus();
                    } else if (status == "multiplication") {
                        multiply();
                    } else if (status == "sum") {
                        plus();
                    } else if (status == "division"){
                        divide();
                    } else {
                        firstNumber = Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator = false;
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number == null){
                    number = "0.";
                } else {
                    number += ".";
                }
                textViewResult.setText(number);
            }
        });
    }

    public void numberClick(String view){
        if(number == null){
            number = view;
        }
        else{
            number = number + view;
        }

        textViewResult.setText(number);
        operator = true;
    }

    public void plus(){
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber += lastNumber;

        textViewResult.setText(myFormatter.format(firstNumber));
    }

    public void minus(){

        if(firstNumber == 0){
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        }
        else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber -= lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }

    public void multiply(){
        if(firstNumber == 0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber *= lastNumber;
        }
        else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber *= lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }

    public void divide(){
        if(firstNumber == 0){
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber /= 1;
        }
        else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber /= lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }
}