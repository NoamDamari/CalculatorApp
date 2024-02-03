package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    double num1;
    double num2;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);
    }

    public void numButtonFunction(View view) {
        Button button = (Button) view;
        String buttonNumber = button.getText().toString();
        result.append(buttonNumber);
    }

    public void operatorButtonFunction(View view) {
        Button operatorButton = (Button) view;
        operator = operatorButton.getText().toString().charAt(0);
        num1 = Double.parseDouble(result.getText().toString());
        result.append(" " + operator + " ");
    }

    public void equalButtonFunction(View view) {
        String resultText = result.getText().toString();
        num2 = Double.parseDouble(resultText.substring(resultText.indexOf(operator) + 2));
        double calcResult = 0;

        switch (operator) {

            case '+':
                calcResult = num1 + num2;
                break;

            case '-':
                calcResult = num1 - num2;
                break;

            case 'X':
                calcResult = num1 * num2;
                break;

            case '/':
                calcResult = num1 / num2;
                break;
        }

        if (calcResult % 1 == 0) {
            int intCalcResult = (int) calcResult;
            result.setText(String.valueOf(intCalcResult));
        }
        else {
            result.setText(String.valueOf(calcResult));
        }
    }

    public void clearAllFunction(View view) {
        result.setText("");
    }

    public void deleteLastCharFunction(View view) {
        String currentText = result.getText().toString();
        String newText;
        if (currentText.isEmpty()) {
            newText = currentText;
        }
        else if (currentText.charAt(currentText.length() - 1) == ' '){
            newText = currentText.substring(0, currentText.length() -3);
        }
        else {
            newText = currentText.substring(0, currentText.length() -1);
        }
        result.setText(newText);
    }
}