package android.app.navjot.catchy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class TelephonyActivity extends AppCompatActivity {

    EditText enterNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);

        //This Explicit Intent is done with the help of this tutorial
        //http://www.javatpoint.com/android-explicit-intent-example
        Bundle extras = getIntent().getExtras();
        String welcomeMessage = extras.getString("welcomeMessage");
        String callToActionMessage = extras.getString("callToActionMessage");
        Toast.makeText(getApplicationContext(), welcomeMessage + "\n" + callToActionMessage  ,Toast.LENGTH_LONG).show();
        //This is the result part of the intent

        enterNumber = (EditText) findViewById(R.id.enterNumber);

    }
}
