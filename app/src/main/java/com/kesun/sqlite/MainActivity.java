package com.kesun.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kesun.sqlite.activeandroid.ActiveActivity;
import com.kesun.sqlite.greendao.GreenDaoActivity;
import com.kesun.sqlite.realm.RealmActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_green_dao).setOnClickListener(this);
        findViewById(R.id.tv_active_dao).setOnClickListener(this);
        findViewById(R.id.tv_realm_dao).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_green_dao: // TODO 18/02/08
                startActivity(new Intent(this, GreenDaoActivity.class));
                break;
            case R.id.tv_active_dao:// TODO 18/02/08
                startActivity(new Intent(this, ActiveActivity.class));
                break;
            case R.id.tv_realm_dao:// TODO 18/02/12
                startActivity(new Intent(this, RealmActivity.class));
                break;
            default:
                break;
        }
    }
}
