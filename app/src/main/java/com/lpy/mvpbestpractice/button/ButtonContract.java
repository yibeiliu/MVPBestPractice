package com.lpy.mvpbestpractice.button;

import com.lpy.mvpbestpractice.BaseView;

/**
 * Created by yibeiliu on 2017/03/22.
 */

public interface ButtonContract {
    interface View extends BaseView<Presenter> {
        void showProgressBar();

        void hideProgressBar();

        void showMessage(String message);

        void showResult(String result);

    }

    interface Presenter {
        void buttonClick();
    }
}
