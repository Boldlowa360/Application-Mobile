package com.example.retrofitliste.http;

import com.example.retrofitliste.transfert.Truc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    //chercher tout les trucs
    @GET("exos/truc/list")
    Call<List<Truc>> listeTrucs();

    //chercher tout les long

    @GET("exos/long/list")
    Call<List<Long>> listeLong();
}
