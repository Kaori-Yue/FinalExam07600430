package com.example.finalexam07600430.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class RegisterModel extends BaseObservable {
	private String fullname = "";
	private String username = "";
	private String password = "";

	@Bindable
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
		notifyPropertyChanged(BR.fullname);
	}

	@Bindable
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		notifyPropertyChanged(BR.username);
	}

	@Bindable
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		notifyPropertyChanged(BR.password);
	}
}
