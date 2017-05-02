package doctor.fresh.com.freshdoctor.model;

import android.util.Log;

import org.json.JSONObject;

import doctor.fresh.com.freshdoctor.http.RetrofitUtil;
import doctor.fresh.com.freshdoctor.http.retrofitapi.LoginApi;
import doctor.fresh.com.freshdoctor.presenter.OnGetVerifyCode;
import doctor.fresh.com.freshdoctor.presenter.OnLoginListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hewei on 2017/5/1.
 */

public class LoginModel implements ILoginModel {
    private static final String TAG = LoginModel.class.getSimpleName();

    public void doLogin(OnLoginListener onLoginListener) {
        Log.d(TAG, "doLogin()");

//        final MainApi.ApiService apiService = RetrofitUtil.getRetrofitInstance().create(MainApi.ApiService.class);
//        Call<JSONObject> call = apiService.getCall();
//        call.enqueue(new Callback<JSONObject>() {
//            @Override
//            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
//                Log.d(TAG, "onResponse(), response:\n" + response.body().toString() + ", \n call: " + call.toString());
//                onBannerListListener.onResponse(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<JSONObject> call, Throwable t) {
//                Log.e(TAG, "onFailure(), call:\n" + t.toString());
//                onBannerListListener.onFailure(t.toString());
//            }
//        });
    }

    @Override
    public void getVerifyCode(String phoneNum, final OnGetVerifyCode onGetVerifyCode) {
        Log.d(TAG, "getVerifyCode(), phoneNum:" + phoneNum);

        final LoginApi.getVerifyCode apiService = RetrofitUtil.getRetrofitInstance().create(LoginApi.getVerifyCode.class);
        Call<JSONObject> call = apiService.getVerifyCode(phoneNum);
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.d(TAG, "onResponse(), response:\n" + response.body().toString() + ", \n call: " + call.toString());
                onGetVerifyCode.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.e(TAG, "onFailure(), call:\n" + t.toString());
                onGetVerifyCode.onFailure(t.toString());
            }
        });
    }
}
