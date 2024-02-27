package com.example.acces_reseau.http;

import com.example.acces_reseau.transfert.Repo;
import com.example.acces_reseau.transfert.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    //Création des requêtes
    //Spécifier
    //le type de retour
    //l'input (utilisateur dans ce cas)
    @GET("users/{utilisateur}/repos")
    Call<String> listReposString(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}/repos")
    Call<List<Repo>> listRepos(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}")
    Call<String> utilisateurString(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}")
    Call<Utilisateur> utilisateur(@Path("utilisateur") String utilisateur);
}
