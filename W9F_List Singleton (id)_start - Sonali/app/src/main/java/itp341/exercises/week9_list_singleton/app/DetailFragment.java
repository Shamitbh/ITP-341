package itp341.exercises.week9_list_singleton.app;

import itp341.exercises.week9_list_singleton.R;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShop;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShopSingleton;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getSimpleName();

    //read a coffee shop from the singleton
    //load a CS on the screen
    //enable deleting from singleton

    //Bundle key
    public static final String ARGS_POSITION = "args_position";

    EditText editName;
    EditText editAddress;
    EditText editCity;
    Spinner spinnerState;
    EditText editZip;
    EditText editPhone;
    EditText editWebsite;
    Button buttonSaveListing;
    Button buttonDeleteListing;

    long id;

    public static String[] states; // read from arrays.xml for US states
    ArrayAdapter<CharSequence> spinnerAdapter;

    public DetailFragment() {
        // Required empty public constructor
    }

    //TODO store newInstance input into fragment argument
    public static DetailFragment newInstance(long id) {
        Bundle args = new Bundle();
        args.putLong(ARGS_POSITION, id);

        DetailFragment f = new DetailFragment();
        f.setArguments(args);

        return f;
    }

    //TODO read bundle argument
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        id = args.getLong(ARGS_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);

        //findViews
        editName = (EditText) v.findViewById(R.id.edit_name);
        editAddress = (EditText) v.findViewById(R.id.edit_address);
        editCity = (EditText) v.findViewById(R.id.edit_city);
        spinnerState = (Spinner) v.findViewById(R.id.spinner_state); // update
        editZip = (EditText) v.findViewById(R.id.edit_zip);
        editPhone = (EditText) v.findViewById(R.id.edit_phone);
        editWebsite = (EditText) v.findViewById(R.id.edit_website);
        buttonSaveListing = (Button) v.findViewById(R.id.button_save_listing);
        buttonDeleteListing = (Button) v.findViewById(R.id.button_delete_listing);

        //load spinner values for States in the coffee shop address
        spinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.states,
                android.R.layout.simple_spinner_item);
        spinnerState.setAdapter(spinnerAdapter);

        // format phone edit text
        editPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        //button listeners
        buttonDeleteListing.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                deleteAndClose();

            }
        });
        buttonSaveListing.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                saveAndClose();

            }
        });

      //TODO check if this is an existing or new listing
        if (id!= -1) {
            CoffeeShop cs = CoffeeShopSingleton.get(getActivity()).getCoffeeShop(id);
            if (cs != null) {
                loadData(cs);
            }
        }
        else { //ADDING A new record
            buttonDeleteListing.setVisibility(View.GONE);
        }

        return v;
    }
    //TODO load data from existing coffee shop object
    private void loadData(CoffeeShop cs) {
        editName.setText(cs.getName());
        editCity.setText(cs.getCity());
    }

    //TODO modify to use arguments
    //TODO Listing should be saved (updated if existing, or added if new)
    private void saveAndClose() {
        Log.d(TAG, "saveAndClose");

        CoffeeShop shop = new CoffeeShop();
        shop.setName(editName.getText().toString());
        shop.setCity(editCity.getText().toString());

        if (id != -1) {       //UPDATING existing shop
            CoffeeShopSingleton.get(getActivity()).updateCoffeeShop(id, shop);
        }
        else {      //ADDING new record
            CoffeeShopSingleton.get(getActivity()).addCoffeeShop(shop);
        }
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();


    }

    //TODO Listing should be deleted (only it was an existing entry, not if it was new))
    private void deleteAndClose() {
        Log.d(TAG, "deleteAndClose");
        //call the singleton remove method
        //finish the activity with OK
        if (id != -1) {
            CoffeeShopSingleton.get(getActivity()).removeCoffeeShop(id);
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
        }

    }

}






