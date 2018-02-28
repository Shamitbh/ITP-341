package itp341.exercises.asynctask_palette;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import itp341.exercises.asynctask_palette.model.Shiba;

/*
    This is an example of color loading using palette
 */

public class Fragment_Palette extends Fragment {
    TextView mTextName;
    TextView mTextAge;
    TextView mTextColor;
    EditText mEditName;
    Spinner mSpinnerColor;
    EditText mEditAge;
    Button mButtonAdd;
    ListView mListView;
    ImageView mImageView;
    LinearLayout mLayout;
    Toolbar mToolbar;

    ArrayList<Shiba> mDogList;
    ArrayAdapter<Shiba> mAdapter;

    public Fragment_Palette() {
        // Required empty public constructor
    }


    public static Fragment_Palette newInstance() {

        Fragment_Palette f = new Fragment_Palette();

        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mTextName = (TextView) v.findViewById(R.id.textName);
        mTextAge = (TextView) v.findViewById(R.id.textAge);
        mTextColor = (TextView) v.findViewById(R.id.textColor);
        mEditName = (EditText) v.findViewById(R.id.editName);
        mSpinnerColor = (Spinner) v.findViewById(R.id.spinnerColor);
        mEditAge = (EditText) v.findViewById(R.id.editAge);
        mButtonAdd = (Button) v.findViewById(R.id.buttonAdd);
        mListView = (ListView) v.findViewById(R.id.listView);
        mImageView = (ImageView) v.findViewById(R.id.imageView);
        mLayout = (LinearLayout) v.findViewById(R.id.outerLayout);


        mDogList = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mDogList);
        mListView.setAdapter(mAdapter);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shiba s = new Shiba();
                s.setName(mEditName.getText().toString());

                String tempInt = mEditAge.getText().toString();
                if (tempInt.equals(""))
                    s.setAge(0);
                else
                    s.setAge(Integer.parseInt(tempInt));


                s.setColor(mSpinnerColor.getSelectedItem().toString());

                mDogList.add(s);
                mAdapter.notifyDataSetChanged();
                Log.d("Shiba", s.toString());
                Log.d("Shiba array", mDogList.toString());
            }
        });


        //TODO complete image loading
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shiba s = mDogList.get(i);
                mEditName.setText(s.getName());
                mEditAge.setText(String.valueOf(s.getAge()));

                Bitmap bm;
                int resId;

                if (s.getColor().equalsIgnoreCase("black")){
                    resId = R.drawable.shiba_black;
                }
                else if (s.getColor().equalsIgnoreCase("sesame")){
                    resId = R.drawable.shiba_sesame;
                }
                else{
                    resId = R.drawable.shiba_white;
                }
                mImageView.setImageResource(resId);
                // generate the palette object, but this requires a separate threat
                // create anonymous async task

                bm = BitmapFactory.decodeResource(getResources(), resId); // standard Android code for loading biitmap
                // the execute method needs the INPUT that goes to doInOnBackground
                new PaletteTask(getActivity()).execute(bm);
            }
        });

        return v;
    }

    private class PaletteTask extends AsyncTask<Bitmap, Void, Palette> {

        private Context context;
        public PaletteTask(Context c){
            this.context = c;
        }

        @Override // this is on a separate thread
        protected Palette doInBackground(Bitmap... params) {
            // because this users variable args, params will be an array
            Bitmap bm = params[0];
            // how we generate a palette object from an image
            Palette p = Palette.from(bm).generate();
            // this GENERATE method is the time-consuming part, hence we use a separate thread

            return p; // this is returned onPostExecute, NOT where we executed the task in mListView listener
        }

        @Override
        protected void onPostExecute(Palette palette) {
            super.onPostExecute(palette);
            // this is ON THE MAIN THREAD
            // therefore we can do UI tasks

            int lightMutedColor = palette.getLightMutedColor(0x00);
            int darkVibrantColor = palette.getDarkVibrantColor(0xFF);

            mListView.setBackgroundColor(lightMutedColor);
            mEditAge.setBackgroundColor(lightMutedColor);
            mEditName.setBackgroundColor(lightMutedColor);
            mTextAge.setBackgroundColor(lightMutedColor);
            mTextName.setBackgroundColor(lightMutedColor);
            mTextColor.setBackgroundColor(lightMutedColor);
            mSpinnerColor.setBackgroundColor(lightMutedColor);

            mLayout.setBackgroundColor(darkVibrantColor);
        }
    }

    //TODO - Palette - change colors
    /*
    Common available Palette colors
        Vibrant
        Vibrant Dark
        Vibrant Light
        Muted
        Muted Dark
        Muted Light
    */

}


