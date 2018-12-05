package com.msi.studyonandroid.uiview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.msi.studyonandroid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btn_add, btn_min, btn_div, btn_mul;
    private Button btn_is, btn_clear;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = findViewById(R.id.cal_textview);

        btn0 = findViewById(R.id.cal_btn0);
        btn1 = findViewById(R.id.cal_btn1);
        btn2 = findViewById(R.id.cal_btn2);
        btn3 = findViewById(R.id.cal_btn3);
        btn4 = findViewById(R.id.cal_btn4);
        btn5 = findViewById(R.id.cal_btn5);
        btn6 = findViewById(R.id.cal_btn6);
        btn7 = findViewById(R.id.cal_btn7);
        btn8 = findViewById(R.id.cal_btn8);
        btn9 = findViewById(R.id.cal_btn9);
        btn_add = findViewById(R.id.cal_btn_add);
        btn_min = findViewById(R.id.cal_btn_min);
        btn_div = findViewById(R.id.cal_btn_div);
        btn_mul = findViewById(R.id.cal_btn_mul);
        btn_is = findViewById(R.id.cal_btn_is);
        btn_clear = findViewById(R.id.cal_btn_clear);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_min.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_is.setOnClickListener(this);
        btn_clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // 获得输入
        String str = textView.getText().toString();
        if (view.getId() == R.id.cal_btn_is) {
            Log.i("CalatorActivity", str);
            // 输入识别数字和操作符，转为中序表达式
            List<String> list = toInfixExpression(str);
            if (list == null || list.size() == 0){
                Toast.makeText(this, "please enter expression!", Toast.LENGTH_LONG).show();
                textView.setText(null);
                return;
            }
            // 转后缀表达式
            list = parseSuffixExpression(list);
            // 计算
            int result = calculate(list);
            textView.setText(""+result);
        } else if(view.getId() == R.id.cal_btn_clear){
            textView.setText(null);
        } else {
                textView.setText(str + ((Button) view).getText());
            }
    }

    // 字符串转中序表达式
    private List<String> toInfixExpression(String str) {
        if (null == str || 0 == str.length()) {

            return null;
        }
        List<String> list = new ArrayList<String>(); // 存储表达式
        String temp;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                //Log.i("toInfixExpression","******");
                temp = "";
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                   // Log.i("toInfixExpression","#######");
                    temp += str.charAt(i);
                    i++;
                }
                list.add(temp);
            } else {
                if(i == 0){ // 直接输入操作符
                   // Toast.makeText(this,"Please enter correct expression!",Toast.LENGTH_LONG).show();
                    return null;
                }
                list.add("" + str.charAt(i));
                i++;
            }
        }
        for (String ss : list)
            Log.i("toInfixExpression",ss+"*");

        return list;

    }

    // 中缀转后缀表达式
    private List<String> parseSuffixExpression(List<String> list) {
        List<String> ls = new ArrayList<String>();
        Stack<String> stack = new Stack<>();

        for (String ss : list) {
            if (ss.matches("\\d+")){
                ls.add(ss);
            }
            else {
                while (stack.size() != 0 && getPriority(stack.peek()) >= getPriority(ss)) {
                    // 栈里面的运算符的优先级更高
                    ls.add(stack.pop());
                }
                stack.push(ss);
            }
        }
        while (stack.size() != 0)
            ls.add(stack.pop());

        System.out.println();
        for (String ss : ls)
            Log.i("parseSuffixExpression",ss+"*" );
        //calculate(ls);
        return ls;
    }

    // 计算后缀表达式
    private int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (String str : list) {
            if (str.matches("\\d+"))
                stack.push(str);
            else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());

                switch (str) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if(0 == b){
                            Toast.makeText(this,"Division can't be 0",Toast.LENGTH_SHORT).show();
                            return -1;
                        }
                        result = a / b;
                        break;
                }
                stack.push(""+result);
            }

        }
        Log.i("calculate",stack.peek() );
        return result;
    }

    private static int getPriority(String operator) {
        int result;
        switch (operator) {
            case "+":
            case "-":
                result = 1;
                break;
            case "/":
            case "*":
                result = 2;
                break;
            default:
                result = 0;
        }
        return result;
    }


}
