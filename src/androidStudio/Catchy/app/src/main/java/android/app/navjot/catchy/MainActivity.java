package android.app.navjot.catchy;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //declaring buttons
    Button callButton;
    Button locationButton;
    Button grosseryButton;
    Button cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting connection using find view by id which helps us connect code with layout elements by their id's
        callButton = (Button) findViewById(R.id.callButton);
        locationButton = (Button) findViewById(R.id.locationButton);
        grosseryButton = (Button) findViewById(R.id.grossaryButton);
        cameraButton = (Button) findViewById(R.id.cameraButton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This Explicit Intent is done with the help of this tutorial
                //http://www.javatpoint.com/android-explicit-intent-example
                Intent openTelephonyActivityIntent = new Intent(getApplicationContext(), TelephonyActivity.class);
                openTelephonyActivityIntent.putExtra("welcomeMessage","Welcome to Telephony Activity");
                openTelephonyActivityIntent.putExtra("callToActionMessage", "You can make a call from here");

            }
        });
    }
}
