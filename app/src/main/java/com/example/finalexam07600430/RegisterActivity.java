package com.example.finalexam07600430;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.finalexam07600430.databinding.ActivityRegisterBinding;
import com.example.finalexam07600430.viewModel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

	private ActivityRegisterBinding binding;
	private RegisterViewModel registerViewModel = new RegisterViewModel(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_register);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
		binding.setRegisterViewModel(registerViewModel);
	}
}
