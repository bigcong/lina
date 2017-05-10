package com.cc.lina;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityWindowInfo;

import java.util.List;

/**
 * Created by bigcong on 2017/3/31.
 */

public class MyService extends AccessibilityService implements View.OnTouchListener {


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.v("gg", event.getEventType() + "");
        Log.v("cc", "gg");
        //接收事件,如触发了通知栏变化、界面变化等
    }

    @Override
    public List<AccessibilityWindowInfo> getWindows() {
        return super.getWindows();
    }

    @Override
    protected boolean onKeyEvent(KeyEvent event) {

        Log.v("hello", "world");
        Log.v("hello", event.getEventTime() + "");

        //接收按键事件
        return super.onKeyEvent(event);
    }

    @Override
    public void onInterrupt() {
        //服务中断，如授权关闭或者将服务杀死
    }


    @Override
    protected void onServiceConnected() {
        AccessibilityServiceInfo serviceInfo = new AccessibilityServiceInfo();
        serviceInfo.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED;
        serviceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        serviceInfo.packageNames = new String[]{"com.cc.lina"};
        serviceInfo.notificationTimeout = 100;
        setServiceInfo(serviceInfo);
        super.onServiceConnected();
        //连接服务后,一般是在授权成功后会接收到
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_UP)
            Log.i("ggggggg", "Action :" + event.getAction() + "\t X :" + event.getRawX() + "\t Y :" + event.getRawY());

        return true;
    }
}
