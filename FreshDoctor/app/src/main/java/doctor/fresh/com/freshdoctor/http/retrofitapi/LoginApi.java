package doctor.fresh.com.freshdoctor.http.retrofitapi;

import org.json.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hewei on 2017/5/1.
 */

public class LoginApi {

    public interface doLogin {

        @GET("user/loginByCode")
        Call<JSONObject> doLogin(@FieldMap Map<String,String> map);
    }

    public interface getVerifyCode {

        @GET("common/getVerifyCode")
        Call<JSONObject> getVerifyCode(@Query("mobile") String phoneNum);
    }
}
