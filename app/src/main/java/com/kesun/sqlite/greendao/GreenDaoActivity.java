package com.kesun.sqlite.greendao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kesun.sqlite.App;
import com.kesun.sqlite.R;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mInsert;
    private TextView mSelect;
    private TextView mDelect;
    private ListView mViewList;
    private GreenDaoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_list);
        initView();

    }

    private void initView() {
        mInsert = (TextView) findViewById(R.id.insert);
        mInsert.setOnClickListener(this);
        mSelect = (TextView) findViewById(R.id.select);
        mSelect.setOnClickListener(this);
        mDelect = (TextView) findViewById(R.id.delect);
        mDelect.setOnClickListener(this);
        mViewList = (ListView) findViewById(R.id.list_view);
        adapter = new GreenDaoAdapter(this);
        mViewList.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                // TODO 18/02/08

                App.getApp().getDaoSession().getStudentDao().insert(new Student("11", "2"));
                List<Student> list = App.getApp().getDaoSession().getStudentDao().loadAll();
                adapter.setList(list);
                break;
            case R.id.select:
                // TODO 18/02/08
                List<Student> notes = App.getApp().getDaoSession().getStudentDao().queryBuilder().build().list();
                adapter.setList(notes);
                break;
            case R.id.delect:
                // TODO 18/02/08
                break;
            default:
                break;
        }
    }
}
