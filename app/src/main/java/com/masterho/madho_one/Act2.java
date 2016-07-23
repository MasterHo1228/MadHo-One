package com.masterho.madho_one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Act2 extends AppCompatActivity{
    private ToggleButton tBtn1;
    private ImageView imgJKL;
    private CheckBox cbConfirm;
    private String confirmText;
//    private Button btnChange2;
    String[] res = {"狗仔铭", "doge铭", "嘴强doge", "低调哥", "小肥X", "肥咸鱼A", "逗比娴", "张污娴", "污龟娴", "魔性的笑A", "张全蛋", "张半蛋", "张没蛋","KAI佬"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        AutoCompleteTextView acText = (AutoCompleteTextView) findViewById(R.id.acText);
        ArrayAdapter<String> adapterName = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
        acText.setAdapter(adapterName);

        MultiAutoCompleteTextView macText = (MultiAutoCompleteTextView) findViewById(R.id.macText1);
        macText.setAdapter(adapterName);
        macText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        tBtn1 = (ToggleButton) findViewById(R.id.tBtn1);
        imgJKL = (ImageView) findViewById(R.id.imgJKL);
        tBtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imgJKL.setImageResource(b?R.drawable.demo2:R.drawable.demo1);
            }
        });

        cbConfirm = (CheckBox) findViewById(R.id.cbConfirm);
        cbConfirm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(Act2.this,confirmText,Toast.LENGTH_LONG).show();
                    tBtn1.setVisibility(View.VISIBLE);
                    imgJKL.setVisibility(View.VISIBLE);
                }
                else{
                    tBtn1.setVisibility(View.INVISIBLE);
                    imgJKL.setVisibility(View.INVISIBLE);
                }
            }
        });

        RadioGroup selectGender = (RadioGroup) findViewById(R.id.selectGender);
        selectGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                cbConfirm.setChecked(false);
                String cbText;
                switch (i){
                    case R.id.genderMale:
                        cbText = "我已阅读并同意该网站的py交♂易协议";
                        cbConfirm.setText(cbText);
                        confirmText = "你已经同意了该网站的py交♂易协议~";
                        break;
                    case R.id.genderFemale:
                        cbText = "我已阅读并同意该网站的捉♂迷♀藏游戏协议";
                        cbConfirm.setText(cbText);
                        confirmText = "你已经同意了该网站的捉♂迷♀藏游戏协议~";
                        break;
                }
                cbConfirm.setVisibility(View.VISIBLE);
            }
        });

        Button btnChange1 = (Button) findViewById(R.id.btnChange1);
        btnChange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Act2 = new Intent(com.masterho.madho_one.Act2.this,Act2A.class);
                com.masterho.madho_one.Act2.this.startActivity(Act2);
            }
        });

        Button btnChange2 = (Button) findViewById(R.id.btnChange2);
        btnChange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Act3 = new Intent(Act2.this,Act2B.class);
                startActivityForResult(Act3,2);
            }
        });

        Button btnBack = (Button) findViewById(R.id.act2BtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode ==2){
            String ReceiveKey = data.getStringExtra("data");
            Toast.makeText(Act2.this,ReceiveKey,Toast.LENGTH_LONG).show();
        }
    }
}
