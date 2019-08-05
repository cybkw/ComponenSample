package com.bkw.module.personal.user;

import com.bkw.module.common.user.bean.BaseUser;
import com.bkw.module.common.user.interfaces.IUser;
import com.bkw.module.personal.model.UserInfo;

public class PersonalUserImpl implements IUser {
    @Override
    public BaseUser getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("彭老师");
        userInfo.setAccount("netease_simon");
        userInfo.setPassword("666666");
        userInfo.setVipLevel(9);
        return userInfo;
    }
}
