package com.moustick.weirdox;

import android.os.Bundle;
import android.renderscript.Short3;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moustick.weirdox.database.Sound;
import com.moustick.weirdox.database.SoundDAO;
import com.moustick.weirdox.database.Weirdo;
import com.moustick.weirdox.database.WeirdoDAO;
import com.moustick.weirdox.database.WeirdosViewModel;
import com.moustick.weirdox.database.WeirdoxDatabase;
import com.moustick.weirdox.db.roomtest.Director;
import com.moustick.weirdox.db.roomtest.DirectorDao;
import com.moustick.weirdox.db.roomtest.DirectorsViewModel;
import com.moustick.weirdox.db.roomtest.MoviesDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

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



        /*DBHelper.openDataBase(getApplicationContext());

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, DBHelper.getDatabaseName()).build();
        System.out.println(db.weirdoDAO().getAll());

        DBHelper.closeDataBase();*/

        DirectorDao directorDao = MoviesDatabase.getDatabase(getApplication()).directorDao();
        LiveData<List<Director>> directorsLiveData = directorDao.getAllDirectors();
        directorDao.insert(new Director("coucou folder"));
        System.out.println("Test " + directorsLiveData);
        DirectorsViewModel directorsViewModel = new DirectorsViewModel(getApplication());
        directorsLiveData.observe(this, new Observer<List<Director>>() {
            @Override
            public void onChanged(List<Director> directors) {
                for (Director director : directors) {
                    System.out.println("TEST + " + director);
                }
            }
        });


        SoundDAO soundDAO = WeirdoxDatabase.getDatabase(getApplication()).soundDAO();
        WeirdoDAO weirdoDAO = WeirdoxDatabase.getDatabase(getApplication()).weirdoDAO();
        LiveData<List<Sound>> soundsLiveData = soundDAO.getAll();

        Weirdo weirdoOne = new Weirdo("Cindytest", "avatar_cindytest");
        soundDAO.insert(new Sound("coucou sound", "un audio", (int) weirdoDAO.insert(weirdoOne)));
        System.out.println("Test " + directorsLiveData);

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
