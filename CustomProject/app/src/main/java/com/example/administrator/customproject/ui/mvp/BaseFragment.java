package com.example.administrator.customproject.ui.mvp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * fragment基类,所有fragment必须实现
 */
public abstract class BaseFragment extends Fragment {
    private Context context;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        initDagger();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (0 != getContentViewId()) {
            View view = inflater.inflate(getContentViewId(), container, false);
            unbinder = ButterKnife.bind(this, view);
            return view;
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }

    protected abstract void initDagger();

    protected abstract void initViewsAndEvents(View rootView);

    protected abstract int getContentViewId();
}
