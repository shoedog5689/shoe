package doctor.fresh.com.freshdoctor.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import doctor.fresh.com.freshdoctor.BaseFragment;
import doctor.fresh.com.freshdoctor.R;

/**
 * Created by hewei on 2017/4/17.
 */

public class MainFragment extends BaseFragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    private TextView textView;

    public static MainFragment newInstance() {
        Log.d(TAG, "newInstance()");
        return new MainFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        textView = (TextView) view.findViewById(R.id.testTv);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}
