package com.wzhnsc.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.test.R;

public class MainActivity extends Activity {
    private EditText     edit;

	static MainHandler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        mHandler = new MainHandler();

		edit = (EditText)findViewById(R.id.editText);
		edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NdkUpdateUI", print("Look! I was updated!"));
            }
        });
	}

	// 对要调用的方法做本地声明
	public static native String print(String nParam);

	static {
		System.loadLibrary("print");
	}

	public static void myCallbackFunc(String nMsg) {
		Message tMsg = new Message();
		Bundle  tBundle = new Bundle();

		tBundle.putString("CMD", nMsg);
		tMsg.setData(tBundle);

		mHandler.sendMessage(tMsg);
	}

	class MainHandler extends Handler {
		public MainHandler() {
		}

		public MainHandler(Looper L) {
			super(L);
		}

		@Override
        public void handleMessage(Message nMsg) {
			super.handleMessage(nMsg);

			Bundle tBundle = nMsg.getData();
			String tCmd = tBundle.getString("CMD");

			MainActivity.this.edit.setText(tCmd);
		}
	}
}
