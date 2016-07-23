package com.masterho.madho_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Act1 extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        Button btnT1 = (Button) findViewById(R.id.btnT1);
        btnT1.setOnClickListener(new OutOnclickListener(){
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Toast.makeText(Act1.this,"此黑科技由煞笔神独♂家♂提供~~",Toast.LENGTH_LONG).show();
                Log.i("tag","You taped btnT1 just now~");
            }
        });
        Button btnT2 = (Button) findViewById(R.id.btnT2);
        btnT2.setOnClickListener(this);

        Button btnBack = (Button) findViewById(R.id.act1BtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void onClick(View view) {
        Log.i("tag","You taped a button just now~");
        Toast.makeText(Act1.this,"亲，你戳了一下一个按钮呦~~",Toast.LENGTH_SHORT).show();
    }
}
class OutOnclickListener implements View.OnClickListener{
    @Override
    public void onClick(View view) {
    }
}