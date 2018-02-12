package com.kesun.sqlite;

import android.app.Application;
import android.os.ParcelUuid;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.kesun.sqlite.activeandroid.User;
import com.kesun.sqlite.greendao.DaoMaster;
import com.kesun.sqlite.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class App extends Application {

    public static final boolean ENCRYPTED = true;

    public static App app;

    private DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        Configuration.Builder builder = new Configuration.Builder(this);
        //手动的添加模型类
        builder.addModelClasses(User.class);
        ActiveAndroid.initialize(builder.create());


        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder().build();
//        Realm.setDefaultConfiguration(config);

        RealmConfiguration config = new  RealmConfiguration.Builder()
                .name("myRealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

        realm = Realm.getInstance(config);

    }

    public Realm realm;

    public Realm getRealm() {
        return realm;
    }

    public static App getApp() {
        return app;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
