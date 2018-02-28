package itp341.bhatia.shamit.a9;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import itp341.bhatia.shamit.a9.Model.Movie;
import itp341.bhatia.shamit.a9.Model.MovieSingleton;

/**
 * Created by Shamit on 11/2/17.
 */

public class DetailFragment extends Fragment {

    // References to widgets
    ImageView detailImage;
    TextView detailTitle;
    TextView detailDescription;
    ListView detailListView;

    EditText detailCommentEditText;
    Button detailCommentBtn;

    // private variables
    Movie m;
    int index;
    public DetailFragment(){
        // Required empty default constructor
    }

    public static DetailFragment newInstance(int pos) {
        Bundle args = new Bundle();
        args.putInt("PositionExtra", pos);
        DetailFragment f = new DetailFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        index = args.getInt("PositionExtra", 0);
        
        // get specific movie
        m = MovieSingleton.get().getMovieAtIndex(index);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.detail_activity, container, false);

        detailImage = (ImageView) v.findViewById(R.id.imageViewLayoutListDetail);
        detailTitle = (TextView) v.findViewById(R.id.titleFindOutDetail);
        detailDescription = (TextView) v.findViewById(R.id.descriptionFindOutDetail);
        detailListView = (ListView) v.findViewById(R.id.listView2);
        detailCommentEditText = (EditText) v.findViewById(R.id.commentEditTextDetail);
        detailCommentBtn = (Button) v.findViewById(R.id.commentBtnDetail);

        final ArrayAdapter<String> arrayAdpt = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, m.getMyList());

        detailListView.setAdapter(arrayAdpt);
        // get the movie from onCreate and update all the views accordingly
        switch (m.getGenre()){
            case 0: // horror
                detailImage.setImageResource(R.drawable.horror);
                break;
            case 1: // sci-fi
                detailImage.setImageResource(R.drawable.scifi);
                break;
            case 2: // comedy
                detailImage.setImageResource(R.drawable.comedy);
                break;
            case 3: // drama
                detailImage.setImageResource(R.drawable.drama);
                break;
            case 4: //action
                detailImage.setImageResource(R.drawable.action);
                break;
            default:
                break;
        }
        detailTitle.setText(m.getTitle());
        detailDescription.setText(m.getDescription());

        detailCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Update the list view according to the comment
                // Remember to add the comment to the movie Singleton
                arrayAdpt.notifyDataSetChanged();
                MovieSingleton.get().addCommentToMovie(detailCommentEditText.getText().toString(), index);
                // clear the text
                detailCommentEditText.setText("");
            }
        });

        return v;
    }


}
