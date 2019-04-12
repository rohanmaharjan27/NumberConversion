package com.example.numberconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_num;
    private TextView tv_num;
    private Button btn_convert;
    private String[] ones={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num=findViewById(R.id.et_num);
        tv_num=findViewById(R.id.tv_num);
        btn_convert=findViewById(R.id.btn_con);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num= Integer.parseInt(et_num.getText().toString());
                if (num<20){
                    tv_num.setText(ones[num]);
                }
                else if (num<100){
                    int tens_convert= num/10;
                    int ones_convert= num%10;

                    if (ones_convert!=0){
                        tv_num.setText(tens[tens_convert]+ " "+ones[ones_convert]);
                    }
                    else {
                        tv_num.setText(tens[tens_convert]);
                    }
                }
                else {
                    int convert_hundreds= num/100;
                    int remainder= num%100;
                    int convert_tens=remainder/10;
                    int convert_ones=remainder%10;

                    if (convert_ones!=0){
                        tv_num.setText(ones[convert_hundreds]+" Hundred "+tens[convert_tens]+" "+ones[convert_ones]);
                    }
                    else {
                        tv_num.setText(ones[convert_hundreds]+" Hundred "+tens[convert_tens]);
                    }
                }
            }
        });
    }
}
