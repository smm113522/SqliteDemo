package com.kesun.sqlite.realm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kesun.sqlite.App;
import com.kesun.sqlite.R;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Administrator on 2018/2/12 0012.
 * Realm 是一个 MVCC （多版本并发控制）数据库，由Y Combinator公司在2014年7月发布一款支持运行在手机、平板和可穿戴设备上的嵌入式数据库，目标是取代SQLite。
 * Realm 本质上是一个嵌入式数据库，他并不是基于SQLite所构建的。它拥有自己的数据库存储引擎，可以高效且快速地完成数据库的构建操作。和SQLite不同，它允许你在持久层直接和数据对象工作。在它之上是一个函数式风格的查询api，众多的努力让它比传统的SQLite 操作更快 。
 * <p>
 * https://www.jianshu.com/p/35cf0ce2a559
 */

public class RealmActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mInsert;
    private TextView mSelect;
    private TextView mDelect;
    private ListView mViewList;
    private RealmDaoAdapter adapter;


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

        adapter = new RealmDaoAdapter(this);
        mViewList.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                // TODO 18/02/12
                ItemInfo itemInfo = new ItemInfo("1","CONTENT","2");

                RealmOperationHelper.getInstance().add(itemInfo);
//                RealmResults<ItemInfo> counters = App.getApp().realm.where(ItemInfo.class).findAll();

                RealmResults<ItemInfo> list = (RealmResults<ItemInfo>) RealmOperationHelper.getInstance()
                        .queryAll(ItemInfo.class);
                adapter.setList(list);

                break;
            case R.id.select:
                // TODO 18/02/12
                RealmResults<ItemInfo> lists = (RealmResults<ItemInfo>) RealmOperationHelper.getInstance()
                        .queryAll(ItemInfo.class);
                adapter.setList(lists);
                break;
            case R.id.delect:
                // TODO 18/02/12
                break;
            case R.id.list_view:
                // TODO 18/02/12
                break;
            default:
                break;
        }
    }
}
