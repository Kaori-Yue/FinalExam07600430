package com.example.finalexam07600430;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.database.DatabaseUtils;
import android.os.Bundle;

import com.example.finalexam07600430.databinding.ActivityLoginBinding;
import com.example.finalexam07600430.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

	private ActivityLoginBinding binding;
//	private LoginViewModel loginViewModel = new LoginViewModel(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_login);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
//		binding.setLoginViewModel(new LoginViewModel(this));
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		binding.setLoginViewModel(new LoginViewModel(this));
	}
}
