package android.app.navjot.catchy;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{

    //declaring buttons
    Button callButton;
    Button locationButton;
    Button grossaryButton;
    Button cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting connection using find view by id which helps us connect code with layout elements by their id's
        callButton = (Button) findViewById(R.id.callButton);
        locationButton = (Button) findViewById(R.id.locationButton);
        grossaryButton = (Button) findViewById(R.id.grossaryButton);
        cameraButton = (Button) findViewById(R.id.cameraButton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Call Button Pressed", Toast.LENGTH_SHORT).show();
                //This Explicit Intent is done with the help of this tutorial
                //http://www.javatpoint.com/android-explicit-intent-example
                Intent startTelephonyActivityIntent = new Intent(getApplicationContext(), TelephonyActivity.class);
                startTelephonyActivityIntent.putExtra("welcomeMessage","Welcome to Telephony Activity");
                startTelephonyActivityIntent.putExtra("callToActionMessage", "You can make a call from here");
                startActivity(startTelephonyActivityIntent);
            }
        });

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Location Button Pressed", Toast.LENGTH_SHORT).show();
                Intent startMyLocationActivityIntent = new Intent(getApplicationContext(), MyLocationActivity.class);
                startActivity(startMyLocationActivityIntent);
            }
        });

        grossaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Gallery Button Pressed", Toast.LENGTH_SHORT).show();
                Intent startGrossaryActivityIntent = new Intent(getApplicationContext(), MyLocationActivity.class);
                startActivity(startGrossaryActivityIntent);
            }
        });
    }
}
