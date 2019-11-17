package com.example.finalexam07600430.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.finalexam07600430.RegisterActivity;
import com.example.finalexam07600430.database.AccountEntity;
import com.example.finalexam07600430.database.AccountRepository;
import com.example.finalexam07600430.database.AppDatabase;
import com.example.finalexam07600430.model.LoginModel;

import java.util.List;

public class LoginViewModel {
	private Context mContext;
	public LoginModel loginModel;

	public LoginViewModel(Context mContext) {
		this.mContext = mContext;
		loginModel = new LoginModel();
		showLog();
	}

	public void onClickRegisterButton() {
		Intent intent = new Intent(mContext, RegisterActivity.class);
		((Activity)mContext).startActivity(intent);
	}

	public void onClickLogin() {

		boolean formStatus = isFormHasData();
		if (formStatus == false) {
			Toast.makeText(mContext, "All fields are required", Toast.LENGTH_SHORT).show();
			return;
		}



		AccountRepository repo = new AccountRepository(mContext);
		AccountRepository.AuthParams authParams = new AccountRepository.AuthParams(loginModel.getUsername(), loginModel.getPassword());
		repo.auth(authParams, new AccountRepository.AuthCallback() {
			@Override
			public void onSuccess(List<AccountEntity> accountEntityList) {
				int status = accountEntityList.size();
				if (status == 0) {
					// fail
					Toast.makeText(mContext, "Invalid username or password", Toast.LENGTH_SHORT).show();
				} else {
					// success
					Toast.makeText(mContext, "Welcome " + accountEntityList.get(0).fullName, Toast.LENGTH_SHORT).show();
				}

			}
		});
	}





	private boolean isFormHasData() {
		boolean status = false;

//		status = loginModel.getFullname().length() > 0 ? true : false;
		status = loginModel.getUsername().length() > 0 ? true : false;
		status = loginModel.getPassword().length() > 0 ? true : false;

		return status;
	}


	private void showLog() {
		AccountRepository repo = new AccountRepository(mContext);
		repo.getAll(new AccountRepository.GetCallback() {
			@Override
			public void onSuccess(List<AccountEntity> itemList) {
				System.out.println("LOG!!! " + itemList.size());
				for(AccountEntity account : itemList) {
					System.out.println(account.username);
				}
			}
		});
	}

}
