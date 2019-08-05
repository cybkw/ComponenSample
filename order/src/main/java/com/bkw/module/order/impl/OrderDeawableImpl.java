package com.bkw.module.order.impl;

import com.bkw.module.arouter_annotation.ARouter;
import com.bkw.module.common.order.drawable.OrderDrawable;
import com.bkw.module.order.R;

@ARouter(path = "/order/getDrawable")
public class OrderDeawableImpl implements OrderDrawable {

    /**
     * 此处返回的drawable可供其他子模块使用
     * 调用者只需实现注解就可拿到该资源
     * <p>
     * 如：@Parameter(name = "/order/getDrawable")
     * OrderDrawable drawable;
     */
    @Override
    public int getDrawable() {
        return R.drawable.ic_blur_circular_black_24dp;
    }
}
