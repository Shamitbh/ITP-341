package itp341.bhatia.shamit.a9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import itp341.bhatia.shamit.a9.Model.Movie;
import itp341.bhatia.shamit.a9.Model.MovieSingleton;

/**
 * Created by Shamit on 11/2/17.
 */

public class MainListFragment extends Fragment {

    private static final String TAG = MainListFragment.class.getSimpleName();
    public static final String EXTRA_POSITION = "extra_position";      //key for the intent extra

    ListView mainListView;
    Button buttonAdd;

    private MovieListAdapter adapter;

    public MainListFragment(){
        // Required empty default constructor
    }

    public static MainListFragment newInstance() {
        Bundle args = new Bundle();
        MainListFragment f = new MainListFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_list, container, false);

        buttonAdd = (Button) v.findViewById(R.id.btnAdd);
        mainListView = (ListView) v.findViewById(R.id.listView1);
        List<Movie> moviesList = MovieSingleton.get().getMovies();
        adapter = new MovieListAdapter(getActivity(), R.layout.layout_list_movie, moviesList);
        mainListView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CreateActivity.class);
                startActivityForResult(i, 0);
            }
        });
        return v;
    }

    public class MovieListAdapter extends ArrayAdapter<Movie>{

        public MovieListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Movie> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //step 1 -- inflate view (row) if necessary
            if (convertView == null) {      //this means row has NEVER been created
                convertView = getActivity().getLayoutInflater().inflate(
                        R.layout.layout_list_movie, null);
            }
            //step 2 -- get references to XML views in the row
            ImageView image = (ImageView) convertView.findViewById(R.id.imageViewLayoutList);
            TextView titleText = (TextView) convertView.findViewById(R.id.titleFindOut);
            TextView descriptionText = (TextView) convertView.findViewById(R.id.descriptionFindOut);
            final Button findMoreBtn = (Button) convertView.findViewById(R.id.btnFindOut);

            //step 3 -- get the new model data
            Movie m = getItem(position);     //getting the specified Movie from the adapter
            // Find more button uses specific movie position
            findMoreBtn.setTag(position);

            //step 4 -- load the data from the model to the view
            int genreLoad = m.getGenre();
            // based on genre, load image
            switch (genreLoad){
                case 0: // horror
                    image.setImageResource(R.drawable.horror);
                    break;
                case 1: // sci-fi
                    image.setImageResource(R.drawable.scifi);
                    break;
                case 2: // comedy
                    image.setImageResource(R.drawable.comedy);
                    break;
                case 3: // drama
                    image.setImageResource(R.drawable.drama);
                    break;
                case 4: //action
                    image.setImageResource(R.drawable.action);
                    break;
                default:
                    break;
            }
            titleText.setText(m.getTitle());
            descriptionText.setText(m.getDescription());

            findMoreBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getActivity().getApplicationContext(), DetailActivity.class);

                    List<Movie> moviesNew = MovieSingleton.get().getMovies();
                    for (int j = 0; j < moviesNew.size(); j++){
                        if (j == (Integer)findMoreBtn.getTag()){
                            i.putExtra("Position", j);
                        }
                    }
                    startActivity(i);
                }
            });

            return convertView;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            refresh();
        }

    }

    public void refresh() {
        adapter.notifyDataSetChanged();
    }
}
