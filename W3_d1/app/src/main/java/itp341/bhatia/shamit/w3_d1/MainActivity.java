package itp341.bhatia.shamit.w3_d1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    // bundle key
    public static final String KEY_NUM_IMAGES = "itp341.bhatia.shamit.w3_d1.num_images";

    private Button buttonCrop;
    private Button buttonNormal;
    private ImageView imageCrop;
    private ImageView imageNormal;

    private int numLoadedImages = 0;

    // outState is a bundle, which is a hash ora  dictionary
    // Key / Value pair
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Storing the value in the bundle
        outState.putInt(KEY_NUM_IMAGES, numLoadedImages);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if savedInstatnceState = null, then activity has never been created
        if (savedInstanceState != null) {
            numLoadedImages = savedInstanceState.getInt(KEY_NUM_IMAGES, 0);
        }

        buttonCrop = (Button) findViewById(R.id.button_crop);
        buttonNormal = (Button) findViewById(R.id.button_normal);
        imageCrop = (ImageView) findViewById(R.id.image_crop);
        imageNormal = (ImageView) findViewById(R.id.image_normal);

        buttonCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(getApplicationContext())
                        .load("https://goo.gl/E1ih4N")
                        .placeholder(R.drawable.placeholder)
                        .into(imageCrop);
            }
        });

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(getApplicationContext())
                        .load("https://goo.gl/E1ih4N")
                        .placeholder(R.drawable.placeholder)
                        .resize(200,200)
                        .centerCrop()
                        .into(imageNormal);

                numLoadedImages++;
                Toast.makeText(getApplicationContext(), Integer.valueOf(numLoadedImages) + " clicks", Toast.LENGTH_LONG).show();
            }
        });

    }
}
