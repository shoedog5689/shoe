package doctor.fresh.com.freshdoctor.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by wei.he on 17/5/2.
 */

public class ScrollViewGroup extends LinearLayout {

    private static final String TAG = ScrollViewGroup.class.getSimpleName();


    public ScrollViewGroup(Context context) {
        super(context);
    }

    public ScrollViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent, event:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            return true;
        }
        return super.onTouchEvent(event);
    }
}
