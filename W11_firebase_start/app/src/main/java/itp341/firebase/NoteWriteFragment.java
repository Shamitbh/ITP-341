package itp341.firebase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import itp341.firebase.model.Note;

public class NoteWriteFragment extends Fragment {

    private static final String ARG_URL = "itp341.firebase.ARG_URL";

    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;
    private Button buttonSave;


    //todo database references
    // need 3 references, one to noteCount, one to note parent, and current note we write
    private DatabaseReference dbRefCount;
    private DatabaseReference dbRefNotes;
    private DatabaseReference dbRefNoteToEdit;


    public NoteWriteFragment() {
        // Required empty public constructor
    }

    public static NoteWriteFragment newInstance(String reference)
    {
        Bundle b = new Bundle();
        b.putString(ARG_URL, reference);

        NoteWriteFragment newFragment = new NoteWriteFragment();
        newFragment.setArguments(b);
        return newFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo get database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //todo get database reference paths
        dbRefNotes = database.getReference(FirebaseRefs.NOTES);
        dbRefCount = database.getReference(FirebaseRefs.NOTE_COUNT);
        // dbRefNotes is the node (or main area) for all notes
        // dbRefCount is the node for tracking number of nodes
        // dbRefNoteToEdit points to exisitng note we are trying to edit

        Bundle args = getArguments();
        //todo get reference to note to be edited (if it exists)
        if (args != null){
            String url = args.getString(ARG_URL);
            if (url != null){
                dbRefNoteToEdit = database.getReferenceFromUrl(url);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_write, container, false);

        editTitle = (EditText) v.findViewById(R.id.noteWriteTitle);
        editAuthor = (EditText) v.findViewById(R.id.noteWriteAuthor);
        editContent = (EditText) v.findViewById(R.id.noteWriteContent);
        buttonSave = (Button) v.findViewById(R.id.noteWriteSave);

        //todo read selected note
        if (dbRefNoteToEdit != null){ // editing existing note -> therefore read existing note data
            // this is how to read ONCE from a specific (ie NOT constantly updated)
            dbRefNoteToEdit.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // this method is called once a read is performed
                    // dataSnapshot represents all the data you are trying to read
                    Note n = dataSnapshot.getValue(Note.class);
                    editAuthor.setText(n.getAuthor());
                    editTitle.setText(n.getTitle());
                    editContent.setText(n.getContent());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        // todo implement saving
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Note n = new Note();
            n.setAuthor(editAuthor.getText().toString()); // we SHOULD check if NULL
            n.setContent(editContent.getText().toString());
            n.setTitle(editTitle.getText().toString());

            if (dbRefNoteToEdit == null){
                DatabaseReference dbRefNewNote = dbRefNotes.push(); // generates NEW unique id for NEW node
                dbRefNewNote.setValue(n);
                getActivity().finish();
            }
            else{ // existing record data
                dbRefNoteToEdit.setValue(n);
                getActivity().finish();
            }
                //todo enable saving new note
                //todo enable updating existing note
                    //todo set up count saving
            }
        });

        return v;
    }

}
