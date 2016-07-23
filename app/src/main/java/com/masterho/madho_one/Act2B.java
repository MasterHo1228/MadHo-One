package com.masterho.madho_one;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Act2B extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2b);

        Button act3BtnBack = (Button) findViewById(R.id.act3BtnBack);
        act3BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView Passkey = (TextView) findViewById(R.id.act3Text);
                String ResponseKey = Passkey.getText().toString();

                Intent data = new Intent();
                data.putExtra("data",ResponseKey);
                setResult(2,data);
                finish();
            }
        });
    }
}
