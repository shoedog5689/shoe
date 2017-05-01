package doctor.fresh.com.freshdoctor.view;

import android.app.Activity;

import doctor.fresh.com.freshdoctor.presenter.ILoginPresenter;

/**
 * Created by hewei on 2017/5/1.
 */

public interface ILoginView {
    public void setPresenter(ILoginPresenter loginPresenter);
    public ILoginPresenter getPresenter();
    public Activity getViewActivity();
}
