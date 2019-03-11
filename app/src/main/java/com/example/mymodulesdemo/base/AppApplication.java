package com.example.mymodulesdemo.base;

import com.example.libbase.base.SnBaseApplication;
import com.example.libbase.net.http.SNNetworkCenter;
import com.example.mymodulesdemo.net.ApiCenter;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author ChenQiuE
 * Date：2019/3/5 17:14
 * Email：1077503420@qq.com
 */
public class AppApplication extends SnBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        SNNetworkCenter.getInstance().setServerUrl(ApiCenter.getServerUrl());

        initLeaks();
    }

    /**
     * 初始化LeakCanary
     */
    private void initLeaks() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
