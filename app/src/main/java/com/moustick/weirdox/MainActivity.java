package com.moustick.weirdox;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moustick.weirdox.db.DBHelper;
import com.moustick.weirdox.db.room.AppDatabase;
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
import androidx.room.Room;

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


    }

}
