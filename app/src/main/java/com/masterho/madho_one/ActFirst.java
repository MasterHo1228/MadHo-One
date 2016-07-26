package com.masterho.madho_one;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActFirst extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_first);

        Button btnAct1 = (Button) findViewById(R.id.btnAct1);
        btnAct1.setOnClickListener(this);

        Button btnAct2 = (Button) findViewById(R.id.btnAct2);
        btnAct2.setOnClickListener(this);

        Button btnAct3 = (Button) findViewById(R.id.btnAct3);
        btnAct3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAct1:
                Intent Act1 = new Intent(ActFirst.this,Act1.class);
                startActivity(Act1);
                break;
            case R.id.btnAct2:
                Intent Act2 = new Intent(ActFirst.this,Act2.class);
                startActivity(Act2);
                break;
            case R.id.btnAct3:
                Intent Act3 = new Intent(ActFirst.this,Act3.class);
                startActivity(Act3);
                break;
        }
    }
}
