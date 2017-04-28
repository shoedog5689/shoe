package doctor.fresh.com.freshdoctor.view;

import android.app.Activity;

import doctor.fresh.com.freshdoctor.presenter.IMainPresenter;

/**
 * Created by hewei on 2017/4/14.
 */

public interface IMainView {
    public void setPresenter(IMainPresenter mainPresenter);
    public IMainPresenter getPresenter();
    public Activity getViewActivity();
}
