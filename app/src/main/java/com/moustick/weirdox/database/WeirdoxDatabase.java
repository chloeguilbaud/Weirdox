package com.moustick.weirdox.database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Favorite.class, Sound.class, Weirdo.class}, version = 1)
public abstract class WeirdoxDatabase extends RoomDatabase {

    private static WeirdoxDatabase INSTANCE;
    private static final String DB_NAME = "weirdox.db";


    public static WeirdoxDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WeirdoxDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeirdoxDatabase.class, DB_NAME)
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("WeirdoxDatabase", "populating with data...");
                                    new PopulateDbAsync(INSTANCE).execute();
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public void clearDb() {
        if (INSTANCE != null) {
            new PopulateDbAsync(INSTANCE).execute();
        }
    }

    public abstract FavoriteDAO favoriteDao();
    public abstract SoundDAO soundDAO();
    public abstract WeirdoDAO weirdoDAO();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final FavoriteDAO favoriteDao;
        private final SoundDAO soundDao;
        private final WeirdoDAO weirdoDao;

        public PopulateDbAsync(WeirdoxDatabase instance) {
            favoriteDao = instance.favoriteDao();
            soundDao = instance.soundDAO();
            weirdoDao = instance.weirdoDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            favoriteDao.deleteAll();
            soundDao.deleteAll();
            weirdoDao.deleteAll();

            Weirdo weirdoOne = new Weirdo("Cindy", "avatar_cindy");
            Weirdo weirdoTwo = new Weirdo("David", "david_avatar");
            Weirdo weirdoThree = new Weirdo("Marion", "marion_avatar");

            Sound soundOne = new Sound("cindy_audio1", "cindy_audio1", (int) weirdoDao.insert(weirdoOne));
            final int weirdoTwoId = (int) weirdoDao.insert(weirdoTwo);
            Sound soundTwo = new Sound("cindy_audio2", "cindy_audio2", weirdoTwoId);
            Sound soundThree = new Sound("cindy_audio3", "cindy_audio3", weirdoTwoId);
            Sound soundFour = new Sound("cindy_audio4", "cindy_audio4", (int) weirdoDao.insert(weirdoThree));

            soundDao.insert(soundOne, soundTwo, soundThree, soundFour);


            /*Director directorOne = new Director("Adam McKay");
            Director directorTwo = new Director("Denis Villeneuve");
            Director directorThree = new Director("Morten Tyldum");
            Movie movieOne = new Movie("The Big Short", (int) soundDao.insert(directorOne));
            final int dIdTwo = (int) soundDao.insert(directorTwo);
            Movie movieTwo = new Movie("Arrival", dIdTwo);
            Movie movieThree = new Movie("Blade Runner 2049", dIdTwo);
            Movie movieFour = new Movie("Passengers", (int) soundDao.insert(directorThree));
            favoriteDao.insert(movieOne, movieTwo, movieThree, movieFour); */


            return null;
        }
    }

}