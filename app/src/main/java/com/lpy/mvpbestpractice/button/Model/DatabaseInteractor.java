package com.lpy.mvpbestpractice.button.Model;

/**
 * Created by yibeiliu on 2017/03/22.
 *
 * Interactor 中是 具体的操作 ， 等同于 Presenter 是粘合剂 负责 Model 和 View 的调度
 */

public class DatabaseInteractor implements IDatabaseInteractor {

    /**
     * 模拟 本地操作数据库
     * @param value
     * @return
     */
    @Override
    public String getHttpString(int value) {

//        这里你应该去实际操作数据库
        String result = "我是读取出来的" + String.valueOf(value);
        return result;
    }
}
