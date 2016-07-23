package com.masterho.madho_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Act3 extends AppCompatActivity implements View.OnClickListener {
    Button btnNum0;
    Button btnNum1;
    Button btnNum2;
    Button btnNum3;
    Button btnNum4;
    Button btnNum5;
    Button btnNum6;
    Button btnNum7;
    Button btnNum8;
    Button btnNum9;

    Button btnDot;
    Button btnAdd;
    Button btnLess;
    Button btnMult;
    Button btnExc;
    Button btnEq;

    Button btnDel;
    Button btnClear;

    TextView CalMonitor;

    protected boolean isClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        //绑定Activity上的控件
        //数字键
        btnNum0 = (Button) findViewById(R.id.btnNum0);
        btnNum1 = (Button) findViewById(R.id.btnNum1);
        btnNum2 = (Button) findViewById(R.id.btnNum2);
        btnNum3 = (Button) findViewById(R.id.btnNum3);
        btnNum4 = (Button) findViewById(R.id.btnNum4);
        btnNum5 = (Button) findViewById(R.id.btnNum5);
        btnNum6 = (Button) findViewById(R.id.btnNum6);
        btnNum7 = (Button) findViewById(R.id.btnNum7);
        btnNum8 = (Button) findViewById(R.id.btnNum8);
        btnNum9 = (Button) findViewById(R.id.btnNum9);
        //小数点以及运算符号键
        btnDot = (Button) findViewById(R.id.btnDot);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnLess = (Button) findViewById(R.id.btnLess);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnExc = (Button) findViewById(R.id.btnExc);
        btnEq = (Button) findViewById(R.id.btnEq);
        //删除、清空键
        btnDel = (Button) findViewById(R.id.btnDel);
        btnClear = (Button) findViewById(R.id.btnClear);
        //“计算器”的“屏幕”
        CalMonitor = (TextView) findViewById(R.id.CalMonitor);
        //绑定按钮控件onclick监听事件
        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);

        btnDot.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnLess.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnExc.setOnClickListener(this);
        btnEq.setOnClickListener(this);

        btnDel.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String MonitorData = CalMonitor.getText().toString();//获取"屏幕"上的临时数据
        String AddedData;
        String LessData;
        switch (view.getId()){//检测按键种类
            case R.id.btnNum0:
            case R.id.btnNum1:
            case R.id.btnNum2:
            case R.id.btnNum3:
            case R.id.btnNum4:
            case R.id.btnNum5:
            case R.id.btnNum6:
            case R.id.btnNum7:
            case R.id.btnNum8:
            case R.id.btnNum9:
            case R.id.btnDot:
                if (isClear){//检测上一轮计算是否完成，若已完成则清空上一轮运算的数据
                    isClear = false;
                    MonitorData = "";
                    CalMonitor.setText("");
                }
                AddedData = MonitorData+((Button)view).getText();//“计算器”输入数据
                CalMonitor.setText(AddedData);
                break;

            case R.id.btnAdd:
            case R.id.btnLess:
            case R.id.btnMult:
            case R.id.btnExc:
                AddedData = MonitorData+" "+((Button)view).getText()+" ";//“计算器”输入数据
                Log.i("tag","Catch!");
                CalMonitor.setText(AddedData);
                break;

            case R.id.btnDel:
                if (isClear){//检测上一轮计算是否完成，若已完成则清空上一轮运算的数据
                    isClear = false;
                    MonitorData = "";
                    CalMonitor.setText("");
                    Log.i("tag","Delete2Clear!");
                } else if (!MonitorData.equals("")){//若是首次运算，则逐字删除
                    LessData = MonitorData.substring(0,MonitorData.length()-1);
                    CalMonitor.setText(LessData);
                    Log.i("tag","Deleted");
                }
                break;
            case R.id.btnClear:
                    isClear = false;
                    MonitorData = "";
                    CalMonitor.setText("");
                    Log.i("tag","Clear!");
                break;
            case R.id.btnEq:
                    getResult();//开始运算
                    Log.i("tag","Start to Calculate~~");
                break;
        }
    }
    private void getResult(){
        String NowData = CalMonitor.getText().toString();//获取用户所输入的算式
        Log.i("tag","get data...");
        if (!NowData.equals("")){
            if (NowData.contains(" ")){//获取“屏幕”上运算式的两个数值和运算符
                double Result = 0;
                String a1 = NowData.substring(0,NowData.indexOf(" "));
                String Y = NowData.substring(NowData.indexOf(" ")+1,NowData.indexOf(" ")+2);
                String a2 = NowData.substring(NowData.indexOf(" ")+3);

                if (!a1.equals("") && !a2.equals("")){//若是完整的算式，则进行正常的运算
                    Log.i("tag","Start Calculating~~");
                    double A1 = Double.parseDouble(a1);//数值转为double型
                    double A2 = Double.parseDouble(a2);//数值转为double型

                    switch (Y) {
                        case "+":
                            Result = A1 + A2;
                            break;
                        case "-":
                            Result = A1 - A2;
                            break;
                        case "×":
                            Result = A1 * A2;
                            break;
                        case "÷":
                            if (A2 == 0) {
                                Result = 0;
                            } else {
                                Result = A1 / A2;
                            }
                            break;
                    }

                    if (!a1.contains(".") && !a2.contains(".")){//若两个数值为整数
                        if (!Y.equals("÷")){//若不是除法运算，则直接转为整型输出结果
                            String rs = ((int) Result)+" ";
                            Log.i("tag","Push Result -> "+rs);
                            CalMonitor.setText(rs);
                        } else {//若为除法运算，则按照double类型以字符串的方式输出结果到“屏幕” 中
                            String rs = String.valueOf(Result)+" ";
                            Log.i("tag","Push Result -> "+rs);
                            CalMonitor.setText(rs);
                        }
                    } else {
                        String rs = Result+" ";
                        Log.i("tag","Push Result -> "+rs);
                        CalMonitor.setText(rs);
                    }
                } else if (!a1.equals("") && a2.equals("")){//若第一个数值不为空，第二个数值为空，则只输出第一个数值
                    Log.i("tag","Push Result -> "+NowData);
                    CalMonitor.setText(NowData);
                } else if (a1.equals("") && !a2.equals("")){//若第一个数值为空，第二个数值不为空，则执行以下运算操作
                    double A2 = Double.parseDouble(a2);

                    switch (Y) {
                        case "+":
                            Result = 0 + A2;
                            break;
                        case "-":
                            Result = A2 - 0;
                            break;
                        case "×":
                            Result = 0;
                            break;
                        case "÷":
                            Result = 0;
                            break;
                    }

                    String rs = Result+" ";
                    CalMonitor.setText(rs);
                } else {//若只按了等于按钮，没输入算式，则只清空“屏幕”
                    CalMonitor.setText("");
                }
            }
            if (isClear){
                isClear = false;
            }
            isClear = true;//标记已完成运算
        }
    }
}
