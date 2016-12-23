package android.app.navjot.catchy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

public class GroceryActivity extends AppCompatActivity {

    SeekBar itemsSeekBar;
    String nofitems;
    Button groceryButton;
    EditText groceryItemName,numberOfItems;
    private GroceryDatabase groceryDatabase;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_grocerylist);
        groceryDatabase = new GroceryDatabase(this);
        groceryItemName = (EditText) findViewById(R.id.groceryItemName);
        numberOfItems = (EditText) findViewById(R.id.numberOfItems);
        groceryButton = (Button) findViewById(R.id.addGroceryItemButton);
        itemsSeekBar = (SeekBar) findViewById(R.id.itemsSeekBar);

        itemsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                nofitems = String.valueOf(progress);
                numberOfItems.setText(nofitems);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SQLiteDatabase DataBase = groceryDatabase.getReadableDatabase();
        Cursor cursor = DataBase.rawQuery("select * from grocery", null);
        cursor.moveToFirst();
        int size = cursor.getCount();
        int i = 0;

        final String[] name = new String[size];
        final String[] number = new String[size];

        try {
            if (cursor.getCount() > 0) {
                while (cursor != null) {
                    name[i] = cursor.getString(cursor.getColumnIndex("name"));
                    number[i] = cursor.getString(cursor.getColumnIndex("noitems"));
                    i++;
                    cursor.moveToNext();
                }
            }
            cursor.close();
            DataBase.close();
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext()," Size= "+size,Toast.LENGTH_LONG).show();
        }

        GroceryCustomList adapter = new GroceryCustomList(GroceryActivity.this, name, number);

        list = (ListView)findViewById(R.id.groceryListView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(GroceryActivity.this, "You Clicked at " +name[+ position], Toast.LENGTH_SHORT).show();
            }
        });


        groceryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                groceryDatabase.CreateGrocListItem(groceryItemName.getText().toString(),numberOfItems.getText().toString());
                Intent startGroceryActivityIntent = new Intent(getApplicationContext(), GroceryActivity.class);
                startActivity(startGroceryActivityIntent);
                finish();

            }
        });


    }
}