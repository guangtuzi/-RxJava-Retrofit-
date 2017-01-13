package com.example.administrator.customproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.orhanobut.logger.Logger;


/**
 * DbOpenHelper 数据库备份并更新
 */

public class DbOpenHelper extends DaoMaster.OpenHelper {
    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Logger.d("=数据库版本有更新=" + "旧版本:" + oldVersion + "|新版本:" + newVersion);
        MigrationHelper.migrate(db, UserDao.class);
    }
}
