package com.kesun.sqlite.activeandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kesun.sqlite.R;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class ActiveActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mInsert;
    private TextView mSelect;
    private TextView mDelect;
    private ListView mViewList;
    private ActiveAdapter activeAdapter;
    private DbManager dbManager;
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

        //对ListView设置点击条目监听，点击某个条目后删除该条目
        mViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DbManager.getInstance().deleteUser(users.get(i));
                query();
                activeAdapter.notifyDataSetChanged();
            }
        });
        dbManager = new DbManager();
        activeAdapter = new ActiveAdapter(this);
        mViewList.setAdapter(activeAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                // TODO 18/02/08
                User user = new User();
                user.setAddr("信阳");
                user.setAge(28);
                user.setUserId(1);
                user.setUserName("张飞");
                dbManager.insertUser(user);
                query();
                break;
            case R.id.select:
                // TODO 18/02/08
                query();
                break;
            case R.id.delect:
                // TODO 18/02/08
                break;
            default:
                break;
        }
    }
    List<User> users;
    //查询所有
    public void query() {
        users = dbManager.queryUser();
        activeAdapter.setList(users);
    }
}
