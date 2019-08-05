package com.bkw.module.common.user.interfaces;

import com.bkw.arouterapi.core.Call;
import com.bkw.module.common.user.bean.BaseUser;

public interface IUser extends Call {
    /**
     * @return 根据不同子模块的具体实现，调用得到不同的结果
     */
    BaseUser getUserInfo();
}
