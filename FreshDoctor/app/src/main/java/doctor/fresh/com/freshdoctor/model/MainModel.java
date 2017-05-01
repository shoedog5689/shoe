package doctor.fresh.com.freshdoctor.model;

import android.util.Log;

import org.json.JSONObject;

import doctor.fresh.com.freshdoctor.http.RetrofitUtil;
import doctor.fresh.com.freshdoctor.http.retrofitapi.MainApi;
import doctor.fresh.com.freshdoctor.presenter.OnBannerListListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wei.he on 17/4/19.
 */

public class MainModel implements IMainModel {

    private static final String TAG = MainModel.class.getSimpleName();

    @Override
    public void getMainBannerList(final OnBannerListListener onBannerListListener) {
        Log.d(TAG, "getMainBannerList()");
        final MainApi.ApiService apiService = RetrofitUtil.getRetrofitInstance().create(MainApi.ApiService.class);
        Call<JSONObject> call = apiService.getCall();
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.d(TAG, "onResponse(), response:\n" + response.body().toString() + ", \n call: " + call.toString());
                onBannerListListener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.e(TAG, "onFailure(), call:\n" + t.toString());
                onBannerListListener.onFailure(t.toString());
            }
        });
    }

}
