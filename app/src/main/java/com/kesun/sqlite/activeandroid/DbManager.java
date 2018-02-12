package com.kesun.sqlite.activeandroid;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class DbManager {

    private volatile static DbManager dbManager;

    public static DbManager getInstance() {
        if (dbManager == null) {
            synchronized (DbManager.class) {
                if (dbManager == null) {
                    dbManager = new DbManager();
                }
            }
        }
        return dbManager;
    }

    //添加数据
    public void insertUser(User user) {
        //操作数据库的对象就是实体类本身
        user.save();
    }

    //删除数据
    public void deleteUser(User user) {
        user.delete();
    }

    //更新数据
    public void updateUser(User user) {
        user.setUserName("关羽");
        user.setAddr("北京");
        //在activeandroid中save既可以创建，也可以修改
        user.save();
    }

    //查询所有的数据
    public List<User> queryUser() {
        List<User> execute = new Select()
                .from(User.class) //model类
                .execute();
        return execute;
    }

    //条件查询
    public List<User> query(String userName) {
        List<User> queryName = new Select()
                .from(User.class)
                .where("userName = ?", userName) //查询条件
                .execute();
        return queryName;
    }

    //条件删除
    public void delete(String userName) {
        new Delete()
                .from(User.class)
                .where("userName = ?", userName)
                .execute();
    }

    //条件更新
    public void update(String userName) {
        Update update = new Update(User.class);
        update.set("addr = ?", "上海")
                .where("userName=?", userName)
                .execute();
    }

}
