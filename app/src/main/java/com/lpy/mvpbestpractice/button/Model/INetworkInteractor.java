package com.lpy.mvpbestpractice.button.Model;

/**
 * Created by yibeiliu on 2017/03/22.
 */

public interface INetworkInteractor {

    interface OnFinishListener{
        void onFinish(String networkResult);
    }

    void getNetworkToDoSomething(OnFinishListener listener);

}
