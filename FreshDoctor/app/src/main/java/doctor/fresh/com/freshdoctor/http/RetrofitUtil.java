package doctor.fresh.com.freshdoctor.http;

import java.io.IOException;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wei.he on 17/4/19.
 */

public class RetrofitUtil {

    public static OkHttpClient genericClient() {
        SSLSocketFactory sslSocketFactory = new SslContextFactory().getSslSocket().getSocketFactory();
        X509TrustManager x509TrustManager = new SslContextFactory().getX509TrustManager();
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json; charset=UTF-8")
                                .addHeader("Accept", "application/json")
                                .addHeader("authorization", "")
                                .addHeader("apt-version", "3")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .sslSocketFactory(sslSocketFactory, x509TrustManager)
                .build();

        return httpClient;
    }
}
