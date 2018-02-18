package inventionstudio.inventionstudioandroid.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import inventionstudio.inventionstudioandroid.R;

public class LandingActivity extends AppCompatActivity {
    public static final String USER_PREFERENCES = "UserPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = this.getSharedPreferences(USER_PREFERENCES, MODE_PRIVATE);
        // TODO: Check if user has ever logged in/ if they have, if current time is < 24hrs from last login
        //        long loginTime = getServerTime();
        //
        //        if (prefs.contains("lastLoginTime")) {
        //            long lastLoginTime = prefs.getLong("lastLoginTime", 0);
        //            if (lastLoginTime - loginTime < 24) {
        //               SharedPreferences.Editor editor = prefs.edit();
        //               editor.remove("username");
        //               editor.remove("OTP");
        //               editor.apply();
        //            }
        //        }

        if (prefs.contains("username") && prefs.contains("OTP")) {
            Intent intent = new Intent(getApplicationContext(), LoadingActivity.class);
            startActivity(intent);
        }

        setContentView(R.layout.activity_landing);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.landing_activity_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_login:

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
