package android.biz.ostw.androidaccessibilitytest;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class AccService extends AccessibilityService {

    private static final String TAG = "DDD";

    public AccService(){
        Log.i(TAG, AccService.class.getName());
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.i(TAG, event.toString());
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        Log.i(TAG, "onServiceConnected");
        super.onServiceConnected();
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;

        // Set the type of feedback your service will provide.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;

        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS;
        info.flags = AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS;
        info.flags = AccessibilityServiceInfo.FLAG_REQUEST_TOUCH_EXPLORATION_MODE;
        info.flags = AccessibilityServiceInfo.FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY;
        info.flags = AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS;

        info.notificationTimeout = 0;
        this.setServiceInfo(info);
    }
}
