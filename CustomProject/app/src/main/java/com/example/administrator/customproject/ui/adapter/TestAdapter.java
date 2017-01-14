package com.example.administrator.customproject.ui.adapter;

import android.content.Context;

import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/1/14.
 */

public class TestAdapter extends CommonAdapter {
    public TestAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder, Object item, int position) {
        // 屏幕适配方案需要对ListView的item布局进行手动适配,recycleView同理
        AutoUtils.auto(viewHolder.getConvertView());
    }
}
