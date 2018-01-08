package com.shenpengliang.sample.recordscoretest;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Description:
 * Created by shenpengliang on 2017/12/22.
 */

class MyOntoucheListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        Log.e("shenpengliang","11111111111");
//        if ((event.getAction() == MotionEvent.ACTION_DOWN)
//                && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight()))) {
//            dismiss();
//            return true;
//        } else if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//            dismiss();
//            return true;
//        } else {
//            return super.onTouchEvent(event);
//        }
        return false;
    }
}
