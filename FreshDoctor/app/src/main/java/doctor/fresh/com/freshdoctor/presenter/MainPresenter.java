package doctor.fresh.com.freshdoctor.presenter;

import android.app.Activity;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import doctor.fresh.com.freshdoctor.common.Utils;
import doctor.fresh.com.freshdoctor.model.IMainModel;
import doctor.fresh.com.freshdoctor.model.MainModel;
import doctor.fresh.com.freshdoctor.view.IMainView;
import doctor.fresh.com.freshdoctor.view.MainFragment;
import doctor.fresh.com.freshdoctor.view.OnGetImageViewList;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by hewei on 2017/4/14.
 */

public class MainPresenter implements IMainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private IMainView mainView;
    private IMainModel mainModel;

    public MainPresenter(IMainView fragment) {
        mainModel = new MainModel();
        mainView = fragment;
        mainView.setPresenter(this);
    }

    /**
     * 构建ViewPager中显示的Image List
     * @return
     */
    @Override
    public void getImageViewList(final OnGetImageViewList onGetImageViewList) {
        Log.d(TAG, "getImageViewList()");

        if (mainModel != null && mainView != null) {
            mainModel.getMainBannerList(new OnBannerListListener() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        Log.d(TAG, "getMainBannerList >> onResponse:" + response.toString());
                        onGetImageViewList.onComplete(handleImageViewList(response.getJSONArray("object")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Utils.showLongToast(mainView.getViewActivity(), e.toString());
                    }
                }

                @Override
                public void onFailure(String errStr) {
                    Utils.showLongToast(mainView.getViewActivity(), errStr);
                }
            });
        }
    }

    private List<ImageView> handleImageViewList(JSONArray jsonArray) {
        List<ImageView> imageViewList = new ArrayList<>();
        if (jsonArray != null) {
            Log.d(TAG, "handleImageViewList >> length:" + jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                ImageView imageView = new ImageView(mainView.getViewActivity());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                try {
                    JSONObject bannerJson = jsonArray.getJSONObject(i);
                    String picUrl = bannerJson.optString("picUrl");
                    Log.d(TAG, "picUrl:" + picUrl);
                    if (bannerJson != null && !TextUtils.isEmpty(picUrl)) {
                        Glide.with(mainView.getViewActivity()).load(picUrl).into(imageView);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Utils.showLongToast(mainView.getViewActivity(), "获取资源出错！！！");
                }
                imageViewList.add(imageView);
            }
        }
        return imageViewList;
    }
}
