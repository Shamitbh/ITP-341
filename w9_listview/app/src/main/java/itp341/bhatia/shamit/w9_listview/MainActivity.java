package itp341.bhatia.shamit.w9_listview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import itp341.bhatia.shamit.w9_listview.Model.Puppy;

public class MainActivity extends AppCompatActivity {

    private String[] puppies;

    ListView myList;
    TextView myText;
    private ArrayList<Puppy> puppyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (ListView)findViewById(R.id.list);
        myText = (TextView)findViewById(R.id.text);

        puppyList = new ArrayList<>();
        puppyList.add(new Puppy("Mocha", "Shiba Inu", 14));
        puppyList.add(new Puppy("Cleo", "German Shepherd", 2));
        puppyList.add(new Puppy("Harris", "Cattle dog", 2));




        // puppies = getResources().getStringArray(R.array.puppies);
        // Now imagine that data comes from cloud -- HAVE TO USE ADAPTER NOW

        //ArrayAdapter<Puppy> adapter = new ArrayAdapter<Puppy>(this, android.R.layout.simple_list_item_1, puppyList);

        PuppyAdapter adapter = new PuppyAdapter(this, R.layout.list_row_puppy, puppyList);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                String puppy = puppyList.get(i).getName();
                myText.setText(puppy);
            }
        });

    }
    // Build adapter within the class WHERE the listview will be loaded
    // This could be the fragment or the activity (depending)
    private class PuppyAdapter extends ArrayAdapter<Puppy> {

        public PuppyAdapter(Context c, int resId, List<Puppy> puppyList) {
            super(c, resId, puppyList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // loading ONE row of the list view
            // Step 1: Check if row has been inflated
            if (convertView == null) { // we need to inflate a row
                convertView = getLayoutInflater().inflate(R.layout.list_row_puppy, null);
            }
            // get references to the items in the XML
            TextView textName = (TextView)convertView.findViewById(R.id.puppy_row_name);
            TextView textBreed = (TextView)convertView.findViewById(R.id.pupp_row_breed);
            TextView textAge = (TextView)convertView.findViewById(R.id.puppy_row_age);

            Puppy p = getItem(position);
            textName.setText(p.getName());
            textAge.setText(Integer.toString(p.getAge()));
            textBreed.setText(p.getBreed());
            return convertView;
        }
    }


}
