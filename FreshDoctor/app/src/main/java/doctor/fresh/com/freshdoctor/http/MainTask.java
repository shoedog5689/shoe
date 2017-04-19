package doctor.fresh.com.freshdoctor.http;

import android.graphics.Bitmap;
import android.util.Log;

import org.json.JSONObject;

import doctor.fresh.com.freshdoctor.common.ApiConst;
import doctor.fresh.com.freshdoctor.http.retrofitapi.MainApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wei.he on 17/4/19.
 */

public class MainTask {

    private static final String TAG = MainTask.class.getSimpleName();

    private static MainTask mainTaskInstance = null;

    public static MainTask getInstance() {
        if (null == mainTaskInstance) {
            synchronized (MainTask.class) {
                if (null == mainTaskInstance) {
                    mainTaskInstance = new MainTask();
                }
            }
        }
        return mainTaskInstance;
    }

    public Bitmap getMainPics() {
        Log.d(TAG, "getMainPics()");
        final MainApi.ApiService apiService = RetrofitUtil.getRetrofitInstance().create(MainApi.ApiService.class);
        Call<JSONObject> call = apiService.getCall();
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.d(TAG, "onResponse(), response:\n" + response.toString());
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.e(TAG, "onFailure(), call:\n" + t.toString());
            }
        });
        return null;
    }

}
