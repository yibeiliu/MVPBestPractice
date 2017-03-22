package com.lpy.mvpbestpractice.button.Model;


import android.os.Handler;

/**
 * Created by yibeiliu on 2017/03/22.
 *
 * Interactor 中是 具体的操作 ， 等同于 Presenter 是粘合剂 负责 Model 和 View 的调度
 */

public class NetworkInteractor implements INetworkInteractor {


    /**
     * 模拟开线程获取网络上的内容
     * @param listener
     */
    @Override
    public void getNetworkToDoSomething(final OnFinishListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinish("我是网上下载的");
            }
        }, 2000);

    }
}
