package se.frojd.gcmchat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gcm.GCMRegistrar;


public class GCMChat extends Activity {
	private String debugAppTag = "** pushAndroidActivity **";
	private TextView mDisplay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		
		setContentView(R.layout.main);
		mDisplay = (TextView) findViewById(R.id.display);
		
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