package com.lpy.mvpbestpractice.button;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lpy.mvpbestpractice.R;

/**
 * A simple {@link Fragment} subclass.
 * 该 fragment 是 View 层 ， 负责展示数据
 */
public class ButtonFragment extends Fragment implements ButtonContract.View, View.OnClickListener {
    private Button mButton;
    private ProgressBar mProgressbar;
    private TextView mTextView;
    private ButtonContract.Presenter mButtonPresenter;


    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mProgressbar = (ProgressBar) view.findViewById(R.id.progreddbar);
        mTextView = (TextView) view.findViewById(R.id.textview);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mButtonPresenter.buttonClick();
                break;
        }
    }

    @Override
    public void setPresenter(ButtonContract.Presenter presenter) {
        mButtonPresenter = presenter;
    }

    @Override
    public void showProgressBar() {
        if (mProgressbar.getVisibility() == View.INVISIBLE) {
            mProgressbar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgressBar() {
        if (mProgressbar.getVisibility() == View.VISIBLE) {
            mProgressbar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResult(String result) {
        if (mTextView.getVisibility() == View.INVISIBLE) {
            mTextView.setVisibility(View.VISIBLE);
        }
        mTextView.setText(result);
    }
}
