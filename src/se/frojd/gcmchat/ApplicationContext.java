package se.frojd.gcmchat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationContext extends Application
{
	private static final String SENDER_ID = "416935735819";
	
    private static ApplicationContext instance 	= null;
    public static SharedPreferences gcmcGeneralSharedPreferences;
    private static int activity_private_mode 	= Activity.MODE_PRIVATE;

    
    public ApplicationContext()
    {
        instance = this;
    }

    public static Context getInstance()
    {
        if (null == instance)
        {
            instance = new ApplicationContext();
        }
        
        openPreferences();
       
        return instance;
    }
    
    private static void openPreferences() {
    	gcmcGeneralSharedPreferences = instance.getSharedPreferences("gcmchat_general_shared_preferences", activity_private_mode);
    }
    
    public static String prefsGet(String key, String default_value) {
   		return gcmcGeneralSharedPreferences.getString(key, default_value);
    }
    
    public static long prefsGet(String key, long default_value) {
    	return gcmcGeneralSharedPreferences.getLong(key, default_value);
    }

    public static Boolean prefsGet(String key, Boolean default_value) {
    	return gcmcGeneralSharedPreferences.getBoolean(key, default_value);
    }
    
    public static int prefsGet(String key, int default_value) {
    	return gcmcGeneralSharedPreferences.getInt(key, default_value);
    }
    
    
    public static void prefsSave(String key, String value) {
		SharedPreferences.Editor gcmcPreferencesEditor = gcmcGeneralSharedPreferences.edit();
		
		gcmcPreferencesEditor.putString(key, value);
		gcmcPreferencesEditor.commit();
    }
    
    public static void prefsSave(String key, Long value) {
		SharedPreferences.Editor gcmcPreferencesEditor = gcmcGeneralSharedPreferences.edit();
		gcmcPreferencesEditor.putLong(key, value);
		gcmcPreferencesEditor.commit();
    }
    
    public static void prefsSave(String key, Boolean value) {
		SharedPreferences.Editor gcmcPreferencesEditor = gcmcGeneralSharedPreferences.edit();
		gcmcPreferencesEditor.putBoolean(key, value);
		gcmcPreferencesEditor.commit();
    }
    
    public static void prefsSave(String key, int value) {
		SharedPreferences.Editor gcmcPreferencesEditor = gcmcGeneralSharedPreferences.edit();
		gcmcPreferencesEditor.putInt(key, value);
		gcmcPreferencesEditor.commit();
    }
    
    public static String getSenderID() {
    	return "416935735819";
    }

}