package com.example.finalexam07600430.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "account")
public class AccountEntity {

	@PrimaryKey(autoGenerate = true)
	@SerializedName("id")
	public int id;

	@ColumnInfo(name = "fullname")
	@SerializedName("fullname")
	public String fullName;

	@ColumnInfo(name = "username")
	@SerializedName("username")
	public String username;

	@ColumnInfo(name = "password")
	@SerializedName("password")
	public String password;

	public AccountEntity(String fullName, String username, String password) {
		this.fullName = fullName;
		this.username = username;
		this.password = password;
	}
}
