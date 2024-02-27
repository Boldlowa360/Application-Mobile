package com.example.acces_reseau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.acces_reseau.http.RetroFitUtil;
import com.example.acces_reseau.http.Service;
import com.example.acces_reseau.transfert.Repo;
import com.example.acces_reseau.transfert.Utilisateur;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Appelet un service de liste et afficher dans le log
        final Service service = RetroFitUtil.get();
        service.listRepos("jorisdequet").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()){
                   //http 200  http tout s'est bien passé
                    List<Repo> resultat = response.body();
                    Log.i("RETROFIT", resultat.size()+"");
                } else {
                    //cas d'erreur http 400 (404)
                    Log.i("RETROFIT",response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                //Erreur accès réseau ou GSON
                Log.i("RETROFIT", t.getMessage());
            }
        });
        //Appeler un service et mettre a jour interface graphique
        final EditText et = findViewById(R.id.editText);
        final Button btn = findViewById(R.id.btnSearch);
        final TextView tv = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = et.getText().toString();
                service.utilisateur(nom).enqueue(new Callback<Utilisateur>() {
                    @Override
                    public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                        if(response.isSuccessful()){
                            tv.setText(response.body().id+"");
                        }else{
                            tv.setText("Erreur avec l'utilisateur entré");
                        }
                    }

                    @Override
                    public void onFailure(Call<Utilisateur> call, Throwable t) {

                    }
                });
            }
        });
    }
}