package com.example.testactivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.Header;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.lib.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				post();
				post2();
			}
		});
		findViewById(R.id.cancle).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				post();
			}
		});
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.i("", "3333");
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		default:
			break;
		}
	}
	
	private void post(){
		AsyncHttpClient http = new AsyncHttpClient();
		RequestParams pa = new RequestParams();
		pa.put("mid", "1");
		try {
			pa.put("keycode", SecurityManager.encryMD5("yj123456"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		pa.put("imageType", "1");
		try {
			pa.put("avatar", new File("/sdcard/yuanju/user/avater.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		http.post("http://211.149.152.140:9080/yuanjuweb/api/photo/modifyPhotosByIdApi", pa, new AsyncHttpResponseHandler() {
		        @Override
				public void onFinish() {
					super.onFinish();
					
					Log.i("22", "onFinish");
					Log.i("22", "onFinish");
					Log.i("22", "onFinish");
					Log.i("22", "onFinish");
				}
				@Override
				public void onSuccess(int statusCode, Header[] headers,
						byte[] responseBody) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					
				}
		});
	}
	

	private void post2(){
		AsyncHttpClient http = new AsyncHttpClient();
		RequestParams pa = new RequestParams();
		pa.put("username", "liming");
		try {
			pa.put("password", SecurityManager.encryMD5("123456"));
			pa.put("keycode", SecurityManager.encryMD5("yj123456"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		http.post("http://211.149.152.140:9080/yuanjuweb/api/member/memberLoginApi",pa, new AsyncHttpResponseHandler(){
				@Override
				public void onStart() {
					Log.i("22", "onStart");
				}

		        @Override
				public void onFinish() {
					super.onFinish();
					Log.i("22", "onFinish");
				}

				@Override
				public void onSuccess(int statusCode, Header[] headers,
						byte[] responseBody) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					
				}
		        
		});
//		task.cancel(true);
	}
	
//	private void post() {
//		RequestParams pa = new RequestParams();
//		pa.put("username", "liming");
//		try {
//			pa.put("password", SecurityManager.encryMD5("123456"));
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//
//		TwitterRestClient.post("yuanjuweb/api/member/memberLoginApi", pa,
//				new AsyncHttpResponseHandler() {
//
//					@Override
//					public void onSuccess(int statusCode, Header[] headers,
//							byte[] responseBody) {
//						// TODO Auto-generated method stub
//					}
//
//					@Override
//					public void onFailure(int statusCode, Header[] headers,
//							byte[] responseBody, Throwable error) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onFinish() {
//						// TODO Auto-generated method stub
//						super.onFinish();
//						dialog.dismiss();
//					}
//					
//				});
//	}

}
