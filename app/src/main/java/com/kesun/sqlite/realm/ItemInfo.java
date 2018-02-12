package com.kesun.sqlite.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2018/2/12 0012.
 */

public class ItemInfo extends RealmObject {

    public String title;
    //内容
    public String content;
    //时间段信息  12：00-13：00

    public String id;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemInfo(String title, String content, String id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }
    public ItemInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ItemInfo() {
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
