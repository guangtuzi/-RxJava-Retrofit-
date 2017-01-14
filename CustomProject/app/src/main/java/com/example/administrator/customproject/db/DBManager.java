package com.example.administrator.customproject.db;

import com.example.administrator.customproject.application.AppHolder;

/**
 * 数据库管理类
 */
public class DBManager {
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static final String DB_NAME = "custom-db";// 数据库名称

    private static class SingleDBManager {
        private static final DBManager SINGLE = new DBManager();
    }

    private DBManager() {
        DbOpenHelper helper = new DbOpenHelper(AppHolder.getContext(), DB_NAME, null);
        mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public static DBManager getInstance() {
        return SingleDBManager.SINGLE;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}  