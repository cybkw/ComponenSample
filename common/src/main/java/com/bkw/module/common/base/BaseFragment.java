package com.bkw.module.common.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseFragment extends SupportFragment {

    Unbinder binder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutView() != null) {
            return getLayoutView();
        }
        return inflater.inflate(getLayoutId(), container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binder = ButterKnife.bind(this, view);
        getBundle(getArguments());
        initData();
        initUI(view);
    }


    protected abstract int getLayoutId();

    public View getLayoutView() {
        return null;
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化UI
     */
    public abstract void initUI(View view);

    /**
     * 获得Activity传递的值
     */
    private void getBundle(Bundle bundle) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binder != null) {
            binder.unbind();
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        if (getFragmentManager() != null) {
            if (getFragmentManager().getBackStackEntryCount() > 1) {
                //如果当前存在fragment>1，当前fragment出栈
                pop();
            } else {
                //已经退栈到root fragment，交由Activity处理回退事件
                return false;
            }
        }
        return true;
    }
}
