package com.bkw.module.common.mvp.factory;


import com.bkw.module.common.mvp.persenter.BaseMvpPresenter;
import com.bkw.module.common.mvp.view.BaseMvpView;

/**
 * @description Presenter工厂接口
 */
public interface PresenterMvpFactory<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {

    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
