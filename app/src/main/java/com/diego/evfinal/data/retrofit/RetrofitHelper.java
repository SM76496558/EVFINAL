package com.diego.evfinal.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {
  public static Retrofit instance;
  public static PeliculasInterface service;

  public RetrofitHelper() {
  }

  public static Retrofit getInstance() {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getLogginBuilder().build())
            .build();
    instance = retrofit;
    return instance;

  };
  public static PeliculasInterface getService() {
    if (service == null){
      service = getInstance().create(PeliculasInterface.class);
    }
    return service;
  }



  public static OkHttpClient.Builder getLogginBuilder() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.level(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.addInterceptor(interceptor);
    return builder;
  }




}
