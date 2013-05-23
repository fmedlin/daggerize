package org.fredmedlin.study;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class MainActivity extends Activity {

    private static String TAG = "Daggerize";

    ObjectGraph objectGraph;
    @Inject RegistrationManager registrationManager;

    TextView statusText;

    public MainActivity() {
        objectGraph = ObjectGraph.create(new RegistrationModule());
        objectGraph.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        statusText = (TextView) findViewById(R.id.text_status);
    }

    public void registerUser(String name) {
        String status = registrationManager.registerUser(name);
        statusText.setText(status);
    }

}

