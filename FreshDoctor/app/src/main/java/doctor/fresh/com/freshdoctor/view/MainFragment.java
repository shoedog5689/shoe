package doctor.fresh.com.freshdoctor.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import doctor.fresh.com.freshdoctor.BaseFragment;
import doctor.fresh.com.freshdoctor.R;

import doctor.fresh.com.freshdoctor.http.MainTask;

/**
 * Created by hewei on 2017/4/17.
 */

public class MainFragment extends BaseFragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    private TextView textView;
    private ViewPager viewPager;

    public static MainFragment newInstance() {
        Log.d(TAG, "newInstance()");
        return new MainFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        textView = (TextView) view.findViewById(R.id.testTv);
        viewPager = (ViewPager) view.findViewById(R.id.main_viewpager);

        Bitmap bitmap = MainTask.getInstance().getMainPics();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}
