package com.example.finalexam07600430.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AccountEntity.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
	private static String DB_NAME = "account.db";
	private static AppDatabase instance;

	public abstract AccountDao accountDao();




	public static synchronized AppDatabase getInstance(Context context) {
		if (instance == null) {
			instance = Room
					.databaseBuilder(
							context.getApplicationContext(),
							AppDatabase.class,
							DB_NAME
					).build();
		}
		return instance;
	}
}

