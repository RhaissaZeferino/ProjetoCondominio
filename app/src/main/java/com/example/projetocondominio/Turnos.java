package com.example.projetocondominio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Turnos extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        Menu menu = bottomNavigationView.getMenu();

        menu.findItem(R.id.action_turnos).setChecked(true);

        if (user != null) {
            menu.findItem(R.id.action_turnos).setVisible(true);
            menu.findItem(R.id.action_profiles).setVisible(true);
            menu.findItem(R.id.action_horario).setVisible(false);
            menu.findItem(R.id.action_profile).setVisible(true);
            menu.findItem(R.id.action_emergency).setVisible(true);
        }
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_turnos:
                        // Ação para o item "Home"
                        Intent horario = new Intent(Turnos.this,Turnos.class);
                        startActivity(horario);
                        return true;
                    case R.id.action_profiles:
                        // Ação para o item "Search"
                        Intent profiles = new Intent(Turnos.this,Profiles.class);
                        startActivity(profiles);
                        return true;
                    case R.id.action_profile:
                        // Ação para o item "Profile"
                        Intent profile = new Intent(Turnos.this,Profile.class);
                        startActivity(profile);
                        return true;
                    case R.id.action_emergency:
                        // Ação para o item "Profile"
                        Intent emergencia = new Intent(Turnos.this,Emergencia.class);
                        startActivity(emergencia);
                        return true;
                }
                return false;
            }
        });
    }
}