package com.lpy.mvpbestpractice.button;

import com.lpy.mvpbestpractice.button.Model.DatabaseInteractor;
import com.lpy.mvpbestpractice.button.Model.IDatabaseInteractor;
import com.lpy.mvpbestpractice.button.Model.INetworkInteractor;
import com.lpy.mvpbestpractice.button.Model.NetworkInteractor;

/**
 * Created by yibeiliu on 2017/03/22.
 *
 * 该 ButtonPresenter 是 Presenter 层 ， 负责调度 V 与 M 层
 */

public class ButtonPresenter implements ButtonContract.Presenter,INetworkInteractor.OnFinishListener{
    private ButtonContract.View mButtonView;
    private IDatabaseInteractor mDatabaseInteractor;
    private INetworkInteractor mNetworkInteractor;

    ButtonPresenter(ButtonContract.View fragment){
        this.mButtonView = fragment;
//        该方法让 fragment 也获得了 presenter 的实例
        mButtonView.setPresenter(this);

//        该 Model 负责操作数据库
        mDatabaseInteractor = new DatabaseInteractor();

//        该 Model 负责操作网络
        mNetworkInteractor= new NetworkInteractor();
    }

    @Override
    public void buttonClick() {
        mButtonView.showProgressBar();

//        模拟 本地读取 需要访问的地址
        String result = mDatabaseInteractor.getHttpString(10);

//        单纯为了展示一下
        mButtonView.showMessage(result);

//        模拟 操作网络 传入回调接口 INetworkModel.OnFinishListener
        mNetworkInteractor.getNetworkToDoSomething(this);

    }

    /**
     * 大家好 我是回调接口
     * @param networkResult
     */
    @Override
    public void onFinish(String networkResult) {
        mButtonView.hideProgressBar();
        mButtonView.showResult(networkResult);
    }
}
