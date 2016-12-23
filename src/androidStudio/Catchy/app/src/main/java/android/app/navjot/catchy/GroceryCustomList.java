package android.app.navjot.catchy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Navjot on 22/12/2016.
 */

public class GroceryCustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final String[] noofitems;

    public GroceryCustomList(Activity context, String[] name, String[] noofitems) {
        super(context, R.layout.listitem, name);
        this.context = context;
        this.name = name;
        this.noofitems = noofitems;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem, null, true);
        TextView itemName = (TextView) rowView.findViewById(R.id.itemNameView);
        TextView  numberOfItems = (TextView) rowView.findViewById(R.id.numberinlistItemsView);

        itemName.setText(name[position]);
        numberOfItems.setText(noofitems[position]);

        return rowView;
    }
}
//This class is done with the help of this discussion
//http://stackoverflow.com/questions/8166497/custom-adapter-for-list-view