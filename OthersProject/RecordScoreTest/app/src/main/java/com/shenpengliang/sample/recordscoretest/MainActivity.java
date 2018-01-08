package com.shenpengliang.sample.recordscoretest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private WindowManager mWindowManager;
    private View mView;
    private boolean isShowing = false;
    private EditText user_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_input = findViewById(R.id.user_input);
    }

    public void showPopUpWindow(View view){
        new MyPopUpWindow(this).showAtLocation(user_input,Gravity.CENTER,0,0);

    }
    public void floatWindow(Context context){
        if(isShowing){
            return ;
        }
        isShowing = true;
        // 获取应用的Context
//        Context mContext = context.getApplicationContext();
        // 获取WindowManager
        mWindowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        mView = setUpView(context);
        int percent = Integer.parseInt(user_input.getText().toString());
        mView.setBackgroundColor(getBlueColor(percent));

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();

        // 类型
        params.type = WindowManager.LayoutParams.TYPE_APPLICATION;

        // WindowManager.LayoutParams.TYPE_SYSTEM_ALERT

        // 设置flag

        int flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
        params.flags = flags;
        // 不设置这个弹出框的透明遮罩显示为黑色
        params.format = PixelFormat.TRANSLUCENT;
        // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
        // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按
        // 不设置这个flag的话，home页的划屏会有问题

        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;

        params.gravity = Gravity.CENTER;

        mWindowManager.addView(mView, params);
    }

    public View setUpView(Context context){
        return LayoutInflater.from(context).inflate(R.layout.filter_view_group,null,false);
    }
    public void removeWindow(){
        if(isShowing){
            mWindowManager.removeView(mView);
            isShowing = false;
        }
    }
    /**
     * 过滤蓝光
     * @param blueFilterPercent 蓝光过滤比例[10-80]
     * */
    public static @ColorInt int getBlueColor(int blueFilterPercent)
    {
        int realFilter = blueFilterPercent;
        if (realFilter < 10)
        {
            realFilter = 10;
        }
        else if (realFilter > 80)
        {
            realFilter = 80;
        }
        int a = (int) (realFilter / 80f * 180);
        int r = (int) (200 - (realFilter / 80f) * 190);
        int g = (int) (180 - ( realFilter / 80f) * 170);
        int b = (int) (60 - realFilter / 80f * 60);
        return Color.argb(a, r, g, b);
    }

    public void showWindow(View view) {
        if(!isShowing){
            floatWindow(this);
        }else{
            removeWindow();
        }
    }

    public void JumpOtherActivity(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.e("shenpengliang","-------->");
        return super.dispatchKeyEvent(event);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("shenpengliang","----onKeyDown---->");
        return super.onKeyDown(keyCode, event);
    }
}
