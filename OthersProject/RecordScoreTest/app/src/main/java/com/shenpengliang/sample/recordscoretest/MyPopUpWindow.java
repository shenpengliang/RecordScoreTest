package com.shenpengliang.sample.recordscoretest;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Description:
 * Created by shenpengliang on 2017/12/22.
 */

public class MyPopUpWindow extends PopupWindow implements View.OnClickListener {
    public View contentView;
    public MyPopUpWindow(Context context) {
        contentView = LayoutInflater.from(context).inflate(R.layout.popup_window_layout, null,
                false);
        contentView.findViewById(R.id.myName).setOnClickListener(this);
        setContentView(contentView);
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(700);
        setFocusable(true);
        setOutsideTouchable(true);

//        setBackgroundDrawable(new BitmapDrawable());
//        setTouchInterceptor(new MyOntoucheListener());
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        contentView.getRootView().setOnTouchListener(new MyOntoucheListener());
        contentView.getRootView().setOnKeyListener(new View.OnKeyListener(){

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.e("shenpengliang","keyCode"+keyCode+"=event="+event.toString());
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(contentView.getContext(),"点击了",Toast.LENGTH_SHORT).show();
    }
}
