package com.msi.studyonandroid.uiview;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.msi.studyonandroid.R;

import java.util.ArrayList;
import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {

    private EditText ex_username, ex_password, ex_phonenumber, ex_date;
    private RadioGroup radioGroup_sex;
    private RadioButton radio_male, radio_female;
    private CheckBox cb_red, cb_blue, cb_yellow, cb_green;
    private Button login_sure, login_cancel;

    private int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 日期选择器
        ex_date = findViewById(R.id.login_ex_date);
        ex_date.setHint(setInstanceDate());
        ex_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(LoginActivity.this, onDateSetListener, year, month, day).show();
            }
        });

        ex_username = findViewById(R.id.login_ex_username);
        ex_password = findViewById(R.id.login_ex_password);
        ex_phonenumber = findViewById(R.id.login_ex_phonenumber);
        radioGroup_sex = findViewById(R.id.login_radio_sex);
        radio_male = findViewById(R.id.login_radio_male);
        radio_female = findViewById(R.id.login_radio_female);
        cb_blue = findViewById(R.id.login_cb_blue);
        cb_red = findViewById(R.id.login_cb_red);
        cb_green = findViewById(R.id.login_cb_green);
        cb_yellow = findViewById(R.id.login_cb_yellow);

        login_cancel = findViewById(R.id.login_btn_cancel);
        login_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 取消按钮，清空输入
                ex_username.setText(null);
                ex_password.setText(null);
                ex_phonenumber.setText(null);
                ex_date.setText(null);
                radioGroup_sex.clearCheck();
                cb_blue.setChecked(false);
                cb_green.setChecked(false);
                cb_red.setChecked(false);
                cb_yellow.setChecked(false);
            }
        });

        login_sure = findViewById(R.id.login_btn_sure);
        login_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ex_username.getText().toString();
                String password = ex_password.getText().toString();
                String phonenumber = ex_phonenumber.getText().toString();
                String date = ex_date.getText().toString();
                // 单选框
                int sex_id = radioGroup_sex.getCheckedRadioButtonId();
                String sex = sex_id == R.id.login_radio_male ? radio_male.getText().toString() : radio_female.getText().toString();
                // 多选
                ArrayList<String> colorlist = new ArrayList<>();
                if (cb_red.isChecked())
                    colorlist.add(cb_red.getText().toString());
                if (cb_blue.isChecked())
                    colorlist.add(cb_blue.getText().toString());
                if (cb_yellow.isChecked())
                    colorlist.add(cb_yellow.getText().toString());
                if (cb_green.isChecked())
                    colorlist.add(cb_green.getText().toString());

                String info = "username:" + username + "\npassword:" + password +
                        "\nphonenumber:" + phonenumber + "\ndate:" + date + "\nsex:" + sex;
                if (null != colorlist && 0 != colorlist.size()) {
                    info += "\ncolor:";
                    for (String str : colorlist)
                        info += str + " ";
                }

                Log.i("LoginActivity", info);
                Toast.makeText(LoginActivity.this,info,Toast.LENGTH_LONG).show();

            }
        });


    }

    private String setInstanceDate() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return (year + "/" + month + "/" + day);
    }

    // 日期的回调监听
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Log.i("LoginActivity", i + "year" + i1 + "month" + i2 + "day");
            year = i;
            month = i1;
            day = i2;
            ex_date.setText(year + "/" + month + "/" + day);
        }
    };


}
