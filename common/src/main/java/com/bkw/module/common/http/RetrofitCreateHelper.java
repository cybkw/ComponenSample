package com.bkw.module.common.http;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.apache.http.conn.ssl.SSLSocketFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求retrofit
 *
 * @author bkw
 */

public class RetrofitCreateHelper {

    private static final int TIMEOUT_READ = 20;
    private static final int TIMEOUT_CONNECTION = 20;
    private static final HttpLoggingInterceptor INTERCEPTOR = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.NONE);
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            //SSL证书
//            .sslSocketFactory(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER,TrustManager.getUnsafeOkHttpClient())
            .hostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER)
            //打印日志
            .addInterceptor(INTERCEPTOR)
            //设置Cache拦截器
            //time out
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            //失败重连
            .retryOnConnectionFailure(true)
            .build();

    public static <T> T createApi(Class<T> clazz, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }


}

