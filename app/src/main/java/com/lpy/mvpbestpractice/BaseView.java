package com.lpy.mvpbestpractice;

/**
 * Created by yibeiliu on 2017/03/22.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
