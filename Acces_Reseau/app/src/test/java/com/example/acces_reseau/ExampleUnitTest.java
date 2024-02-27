package com.example.acces_reseau;

import org.junit.Test;

import android.util.Log;

import com.example.acces_reseau.http.RetroFitUtil;
import com.example.acces_reseau.http.Service;
import com.example.acces_reseau.transfert.Repo;
import com.example.acces_reseau.transfert.Utilisateur;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //test pour chaque requête pour afficher dans le log le résultat de la requête
    @Test
    public void testSimple() throws IOException {
        Service service = RetroFitUtil.get();
        Call<String> call = service.listReposString(    "jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT",resultat);
    }
    @Test
    public void testSimpleStructure() throws IOException {
        Service service = RetroFitUtil.get();
        Call<List<Repo>> call = service.listRepos(    "jorisdeguet");
        Response<List<Repo>> response = call.execute();
        List<Repo> resultat = response.body();
        Log.i("RETROFIT",resultat.toString());
    }
    @Test
    public void testSimpleUtilisateur() throws IOException {
        Service service = RetroFitUtil.get();
        Call<String> call = service.utilisateurString("jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT",resultat);
    }
    @Test
    public void testSimpleUtilisateurStructure() throws IOException {
        Service service = RetroFitUtil.get();
        Call<Utilisateur> call = service.utilisateur("jorisdeguet");
        Response<Utilisateur> response = call.execute();
        Utilisateur resultat = response.body();
        Log.i("RETROFIT",resultat.toString());
    }
}