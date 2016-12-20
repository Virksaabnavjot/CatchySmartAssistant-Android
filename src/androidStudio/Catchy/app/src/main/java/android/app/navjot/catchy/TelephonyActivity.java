package android.app.navjot.catchy;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class TelephonyActivity extends AppCompatActivity {

    EditText enterNumber;
    Button callPhoneButton;

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

        //Finding by its id
        enterNumber = (EditText) findViewById(R.id.enterNumber);
        callPhoneButton = (Button) findViewById(R.id.callPhoneButton);

        callPhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checking if the textedits are empty or not or if the number is incorrect
                if (TextUtils.isEmpty(enterNumber.getText().toString()) || enterNumber.getText().toString().length() < 8 || enterNumber.getText().toString().length() > 8) {
                    Toast.makeText(getApplicationContext(), "Please Check the Number", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    String phoneNumber = enterNumber.getText().toString();

                    //This bit below is done with the help of this tutorial
                    //https://www.tutorialspoint.com/android/android_phone_calls.htm
                    //Implicit Intent
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:03538"+phoneNumber));

                    if (ActivityCompat.checkSelfPermission(TelephonyActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    startActivity(callIntent);


                }


            }
        });

    }
}
