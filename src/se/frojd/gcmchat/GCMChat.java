package se.frojd.gcmchat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gcm.GCMRegistrar;


public class GCMChat extends Activity {
	private String debugAppTag = "** pushAndroidActivity **";
	private TextView tv_sender_nickname;
	private TextView tv_recipients_nickname;
	private TextView tv_message;
	private Button btn_read_more_button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		
		setContentView(R.layout.main);
		tv_sender_nickname = (TextView) findViewById(R.id.sender_nickname);
		tv_recipients_nickname = (TextView) findViewById(R.id.recipients_nickname);
		tv_message = (TextView) findViewById(R.id.message);
		btn_read_more_button = (Button) findViewById(R.id.read_more_button);
		
		final String regId = GCMRegistrar.getRegistrationId(this);
		Log.i(debugAppTag, "registration id =====  "+regId);
		
		if (regId.equals("")) {
			GCMRegistrar.register(this, "SOME_UNIQUE_SENDER_ID");
		}
		else {
			Log.v(debugAppTag, "Already registered");
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		GCMRegistrar.unregister(this);
	}
}