package com.kesun.sqlite.greendao;

import com.kesun.sqlite.activeandroid.DbManager;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class DaoManage {

    private volatile static DaoManage dbManager;

    public static DaoManage getInstance() {
        if (dbManager == null) {
            synchronized (DbManager.class) {
                if (dbManager == null) {
                    dbManager = new DaoManage();
                }
            }
        }
        return dbManager;
    }
}
