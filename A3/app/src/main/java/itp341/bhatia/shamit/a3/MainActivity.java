package itp341.bhatia.shamit.a3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    // EXTRA CREDIT: Saving variable nums + changing background color to Red + scrollView

    // bundle keys -> had to hard-code this b/c the static was messing things up
    public static final String KEY_AMERICAN_COUNT = "itp341.bhatia.shamit.w3_d1.american_count";
    public static final String KEY_CHINESE_COUNT = "itp341.bhatia.shamit.w3_d1.chinese_count";
    public static final String KEY_INDIAN_COUNT = "itp341.bhatia.shamit.w3_d1.indian_count";
    public static final String KEY_ITALIAN_COUNT = "itp341.bhatia.shamit.w3_d1.italian_count";
    public static final String KEY_MIDDLE_EAST_COUNT = "itp341.bhatia.shamit.w3_d1.middle_east_count";
    public static final String KEY_PORTUGUESE_COUNT = "itp341.bhatia.shamit.w3_d1.portuguese_count";

    private ImageView imageAmerican;
    private ImageView imageChinese;
    private ImageView imageIndian;
    private ImageView imageItalian;
    private ImageView imageMiddleEast;
    private ImageView imagePortuguese;

    // Have variables to keep track of user clicks for image views
    private int americanCount = 1;
    private int chineseCount = 1;
    private int indianCount = 1;
    private int italianCount = 1;
    private int middleEastCount = 1;
    private int portugueseCount = 1;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_AMERICAN_COUNT, americanCount);
        outState.putInt(KEY_CHINESE_COUNT, chineseCount);
        outState.putInt(KEY_INDIAN_COUNT, indianCount);
        outState.putInt(KEY_ITALIAN_COUNT, italianCount);
        outState.putInt(KEY_MIDDLE_EAST_COUNT, middleEastCount);
        outState.putInt(KEY_PORTUGUESE_COUNT, portugueseCount);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if savedInstanceState = null, then activity has never been created
        if (savedInstanceState != null) {
            americanCount = savedInstanceState.getInt(KEY_AMERICAN_COUNT, 0);
            chineseCount = savedInstanceState.getInt(KEY_CHINESE_COUNT, 0);
            indianCount = savedInstanceState.getInt(KEY_INDIAN_COUNT, 0);
            italianCount = savedInstanceState.getInt(KEY_ITALIAN_COUNT, 0);
            middleEastCount = savedInstanceState.getInt(KEY_MIDDLE_EAST_COUNT, 0);
            portugueseCount = savedInstanceState.getInt(KEY_PORTUGUESE_COUNT, 0);
        }


        imageAmerican = (ImageView)findViewById(R.id.image_american);
        imageChinese = (ImageView)findViewById(R.id.image_chinese);
        imageIndian = (ImageView)findViewById(R.id.image_indian);
        imageItalian = (ImageView)findViewById(R.id.image_italian);
        imageMiddleEast = (ImageView)findViewById(R.id.image_middle_east);
        imagePortuguese = (ImageView)findViewById(R.id.image_portuguese);

        imageAmerican.setOnClickListener(new ButtonListener());
        imageChinese.setOnClickListener(new ButtonListener());
        imageIndian.setOnClickListener(new ButtonListener());
        imageItalian.setOnClickListener(new ButtonListener());
        imageMiddleEast.setOnClickListener(new ButtonListener());
        imagePortuguese.setOnClickListener(new ButtonListener());


        // Load american food image
        Picasso.with(getApplicationContext())
                .load(getString(R.string.american_link))
                .resize(150,150)
                .into(imageAmerican);
        // Load chinese food image
        Picasso.with(getApplicationContext())
                .load(getString(R.string.chinese_link))
                .resize(150,150)
                .into(imageChinese);
        // Load indian food image
        Picasso.with(getApplicationContext())
                .load(getString(R.string.indian_link))
                .resize(150,150)
                .into(imageIndian);
        // Load italian food image
        Picasso.with(getApplicationContext())
                .load(getString(R.string.italian_link))
                .resize(150,150)
                .into(imageItalian);
        // Load middle eastern food image
        Picasso.with(getApplicationContext())
                .load(getString(R.string.middle_east_link))
                .resize(150,150)
                .into(imageMiddleEast);
        // Load portuguese food image
        Picasso.with(getApplicationContext())
                .load(getString(R.string.portuguese_link))
                .resize(150,150)
                .into(imagePortuguese);

    }

    class ButtonListener implements OnClickListener {

        @Override public void onClick(View v) {
            // Switch statement to identify between the ImageViews
            switch (v.getId()) {
                // Case for American
                case R.id.image_american:
                    if (americanCount == 1){
                        // print time not times
                        String outputAmerican = getString(R.string.liked)+getString(R.string.americanFood)+americanCount+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputAmerican, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputAmerican = getString(R.string.liked)+getString(R.string.americanFood)+americanCount+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputAmerican, Toast.LENGTH_SHORT).show();
                    }
                    americanCount++;
                    break;
                // Case for Chinese
                case R.id.image_chinese:
                    if (chineseCount == 1){
                        // print time not times
                        String outputChinese = getString(R.string.liked)+getString(R.string.chineseFood)+chineseCount+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputChinese, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputChinese = getString(R.string.liked)+getString(R.string.chineseFood)+chineseCount+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputChinese, Toast.LENGTH_SHORT).show();
                    }
                    chineseCount++;
                    break;
                // Case for Indian
                case R.id.image_indian:
                    if (indianCount == 1){
                        // print time not times
                        String outputIndian = getString(R.string.liked)+getString(R.string.indianFood)+indianCount+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputIndian, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputIndian = getString(R.string.liked)+getString(R.string.indianFood)+indianCount+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputIndian, Toast.LENGTH_SHORT).show();
                    }
                    indianCount++;
                    break;
                // Case for Italian
                case R.id.image_italian:
                    if (italianCount == 1){
                        // print time not times
                        String outputItalian = getString(R.string.liked)+getString(R.string.italianFood)+italianCount+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputItalian, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputItalian = getString(R.string.liked)+getString(R.string.italianFood)+italianCount+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputItalian, Toast.LENGTH_SHORT).show();
                    }
                    italianCount++;
                    break;
                // Case for Middle Eastern
                case R.id.image_middle_east:
                    if (middleEastCount == 1){
                        // print time not times
                        String outputMiddleEast = getString(R.string.liked)+getString(R.string.middleEastFood)+middleEastCount+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputMiddleEast, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputMiddleEast = getString(R.string.liked)+getString(R.string.middleEastFood)+middleEastCount+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputMiddleEast, Toast.LENGTH_SHORT).show();
                    }
                    middleEastCount++;
                    break;
                // Case for Portuguese
                case R.id.image_portuguese:
                    if (portugueseCount == 1){
                        // print time not times
                        String outputPortuguese = getString(R.string.liked)+getString(R.string.portugueseFood)+portugueseCount+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputPortuguese, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputPortuguese = getString(R.string.liked)+getString(R.string.portugueseFood)+portugueseCount+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputPortuguese, Toast.LENGTH_SHORT).show();
                    }
                    portugueseCount++;
                    break;
                default:
                    break;
            }
        }
    }
}
