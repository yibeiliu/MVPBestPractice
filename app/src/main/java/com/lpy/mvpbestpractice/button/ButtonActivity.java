package com.lpy.mvpbestpractice.button;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.lpy.mvpbestpractice.R;

/**
 * Activity 只负责管理生命周期，他是上帝视角，仅仅创建 presenter 和 fragment 实例
 */
public class ButtonActivity extends AppCompatActivity {

    private ButtonFragment mButtonFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mButtonFragment = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        if (mButtonFragment == null) {
            mButtonFragment = new ButtonFragment();

            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.frameLayout, mButtonFragment);
            transaction.commit();
        }

        /*
        fragment传入presenter，ButtonPresenter就获得了该fragment的实例
         */
        new ButtonPresenter(mButtonFragment);
    }
}
