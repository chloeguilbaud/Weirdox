package com.moustick.weirdox;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moustick.weirdox.database.Sound;
import com.moustick.weirdox.database.SoundDAO;
import com.moustick.weirdox.database.Weirdo;
import com.moustick.weirdox.database.WeirdoDAO;
import com.moustick.weirdox.database.WeirdosViewModel;
import com.moustick.weirdox.database.WeirdoxDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_favorites, R.id.navigation_weird_boxes, R.id.navigation_sounds)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // Database testing
        SoundDAO soundDAO = WeirdoxDatabase.getDatabase(getApplication()).soundDAO();
        WeirdoDAO weirdoDAO = WeirdoxDatabase.getDatabase(getApplication()).weirdoDAO();
        LiveData<List<Sound>> soundsLiveData = soundDAO.getAll();

        Weirdo weirdoOne = new Weirdo("Cindytest", "avatar_cindytest");
        soundDAO.insert(new Sound("coucou sound", "un audio", (int) weirdoDAO.insert(weirdoOne)));
        System.out.println("Test " + soundsLiveData);

        WeirdosViewModel weirdosViewModel = new WeirdosViewModel(getApplication());
        soundsLiveData.observe(this, new Observer<List<Sound>>() {
            @Override
            public void onChanged(List<Sound> sounds) {
                for (Sound sound : sounds) {
                    System.out.println("TEST + " + sound);
                }
            }
        });


    }

}
