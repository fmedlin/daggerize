package org.fredmedlin.study;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static String TAG = "Daggerize";

    TextView statusText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        statusText = (TextView) findViewById(R.id.text_status);
    }

    public void registerUser(String name) {
        String status = RegistrationManager.getInstance().registerUser(name);
        statusText.setText(status);
    }

}

