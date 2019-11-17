package com.example.finalexam07600430.viewModel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.finalexam07600430.database.AccountEntity;
import com.example.finalexam07600430.database.AccountRepository;
import com.example.finalexam07600430.model.RegisterModel;

public class RegisterViewModel {
	private Context mContext;
	public RegisterModel registerModel;
	public RegisterViewModel(Context mContext) {
		this.mContext = mContext;
		registerModel = new RegisterModel();
	}




	public void onClickRegisterButton() {
		boolean formStatus = isFormHasData();
		if (formStatus == false) {
			Toast.makeText(mContext, "All fields are required", Toast.LENGTH_SHORT).show();
			return;
		}

		AccountRepository repo = new AccountRepository(mContext);

		AccountEntity account = new AccountEntity(registerModel.getFullname(), registerModel.getUsername(), registerModel.getPassword());

		repo.insertAccount(account, new AccountRepository.InsertCallback() {
			@Override
			public void onSuccess() {
				Toast.makeText(mContext, "Register successfully", Toast.LENGTH_SHORT).show();

				System.out.println(mContext.getClass().toString());
				((Activity)mContext).finish();
			}
		});

	}

	private boolean isFormHasData() {
		boolean status = false;

		status = registerModel.getFullname().length() > 0 ? true : false;
		status = registerModel.getUsername().length() > 0 ? true : false;
		status = registerModel.getPassword().length() > 0 ? true : false;

		return status;
	}
}
