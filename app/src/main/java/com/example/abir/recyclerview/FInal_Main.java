package com.example.abir.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FInal_Main extends AppCompatActivity {

    @BindView(R.id.normal)
    Button normal;
    @BindView(R.id.dynamic)
    Button dynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final__main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.normal, R.id.dynamic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.normal:
                startActivity(new Intent(FInal_Main.this, MainActivity.class));
                break;
            case R.id.dynamic:
                startActivity(new Intent(FInal_Main.this, Dynamic_Recyclerview.class));
                break;
        }
    }
}
