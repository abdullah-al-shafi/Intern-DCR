package com.shafi.sbf.interndcr;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface Data {
    @Headers({
                    "Content-Type: application/json"
            })
    @GET("appinion-dev/intern-dcr-data/master/data.json")
    Call<AllList> getAllData();
}
