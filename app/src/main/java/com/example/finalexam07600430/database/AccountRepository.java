package com.example.finalexam07600430.database;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class AccountRepository {
	private Context mContent;

	public AccountRepository(Context mContent) {
		this.mContent = mContent;
	}


	//region getAll

	public interface GetCallback {
		void onSuccess(List<AccountEntity> itemList);
	}


	public void getAll(GetCallback callback) {
		GetTask getTask = new GetTask(mContent, callback);
		getTask.execute();
	}

	private static class GetTask extends AsyncTask<Void, Void, List<AccountEntity>> {
		private Context context;
		private GetCallback callback;

		public GetTask(Context context, GetCallback callback) {
			this.context = context;
			this.callback = callback;
		}

		@Override
		protected List<AccountEntity> doInBackground(Void... voids) {
			AppDatabase db = AppDatabase.getInstance(context);
			List<AccountEntity> itemList = db.accountDao().getAll();
			return itemList;
		}

		@Override
		protected void onPostExecute(List<AccountEntity> accountEntityList) {
			super.onPostExecute(accountEntityList);
			callback.onSuccess(accountEntityList);
		}
	}
	//endregion


	//region Auth

	public void auth(AuthParams params, AuthCallback callback) {
		AuthTask authTask = new AuthTask(mContent, callback);
		authTask.execute(params);
	}

	public interface AuthCallback {
		void onSuccess(List<AccountEntity> accountEntityList);
	}

	public static class AuthParams {
		String username;
		String password;

		public AuthParams(String username, String password) {
			this.username = username;
			this.password = password;
		}
	}



	private static class AuthTask extends AsyncTask<AuthParams, Void, List<AccountEntity>> {
		private Context mContext;
		private AuthCallback callback;

		public AuthTask(Context mContext, AuthCallback callback) {
			this.mContext = mContext;
			this.callback = callback;
		}

		@Override
		protected void onPostExecute(List<AccountEntity> accountEntities) {
			super.onPostExecute(accountEntities);
			this.callback.onSuccess(accountEntities);
		}

		@Override
		protected List<AccountEntity> doInBackground(AuthParams... authParams) {
			String username = authParams[0].username;
			String password = authParams[0].password;
			AppDatabase appDatabase = AppDatabase.getInstance(mContext);
			List<AccountEntity> account =  appDatabase.accountDao().auth(username, password);
			return account;
		}
	}

	//endregion



	//region Insert

	public interface InsertCallback {
		void onSuccess();
	}

	public void insertAccount(AccountEntity account, InsertCallback callback) {
		InsertTask insertTask = new InsertTask(mContent, callback);
		insertTask.execute(account);
	}

	private static class InsertTask extends AsyncTask<AccountEntity, Void, Void> {
		private Context mContext;
		private InsertCallback callback;

		public InsertTask(Context mContext, InsertCallback callback) {
			this.mContext = mContext;
			this.callback = callback;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			callback.onSuccess();
		}

		@Override
		protected Void doInBackground(AccountEntity... accountEntities) {
			AppDatabase appDatabase = AppDatabase.getInstance(mContext);
			for (AccountEntity account : accountEntities) {
				appDatabase.accountDao().insert(account);
			}
			return null;
		}
	}


	//endregion
}
