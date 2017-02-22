package com.cnlive.libs;

import android.app.Application;

import com.cnlive.libs.util.Config;

/**
 * Created by Mr.hou on 2016/7/22.
 */
public class CNLiveApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //配置项目对应的appid和appkey
        Config.init(this, "60_irg1rhs308", "4e7a37b27a717a9e9b0a7aea4620ee55ea61fbf923bf46");
    }
}
