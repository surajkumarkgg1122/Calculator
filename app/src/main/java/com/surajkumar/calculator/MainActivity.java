package com.surajkumar.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {
    Button btn00, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPercent, btnPlus, btnMinus, btnMultiply, btnDivision, btnEqual, btnClear, btnDot, btnBackSpace, btnBracket;
    TextView tvInput, tvOutput;
    String process;
    String finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn00 = findViewById(R.id.btn00);
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

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);

        btnEqual = findViewById(R.id.btnEqual);

        btnClear = findViewById(R.id.btnClear);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnDot = findViewById(R.id.btnDot);

        tvInput = findViewById(R.id.workingsTextView);
        tvOutput = findViewById(R.id.resultTextView);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=removeLastChar(process);
                tvInput.setText(process);
            }
        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "00");
                processData();
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "0");
                processData();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "1");
                processData();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "2");
                processData();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "3");
                processData();
            }
        });
        btn4.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "4");
            processData();
        });

        btn5.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "5");
            processData();
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "6");
                processData();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "7");
                processData();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "8");
                processData();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "9");
                processData();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "+");
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "×");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "÷");

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + ".");
                processData();
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processData();
                process=finalResult;
                tvInput.setText(finalResult);
                tvOutput.setText("");
            }
        });
    }
    private void processData(){

        process = tvInput.getText().toString();

        process = process.replaceAll("×", "*");
        process = process.replaceAll("%", "/100");
        process = process.replaceAll("÷", "/");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        finalResult = "";

        try {
            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
        } catch (Exception e) {
            finalResult = "0";
        }

        tvOutput.setText(finalResult);
    }

    public static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

}