package com.example.finalexam07600430.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccountDao {

	@Query("SELECT * FROM account")
	List<AccountEntity> getAll();

	@Query("SELECT * FROM account WHERE username = :username AND password = :password")
	List<AccountEntity> auth(String username, String password);

	@Insert
	void insert(AccountEntity account);

}
