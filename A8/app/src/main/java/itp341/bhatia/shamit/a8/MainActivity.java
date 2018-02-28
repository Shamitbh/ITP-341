package itp341.bhatia.shamit.a8;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Get references to widgets
    private Button tipCalcBtn;
    private Button unitConvBtn;
    private Button moneyExchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipCalcBtn = (Button)findViewById(R.id.tipCalcBtn);
        unitConvBtn = (Button)findViewById(R.id.unitConvBtn);
        moneyExchBtn = (Button)findViewById(R.id.moneyExchBtn);

        tipCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment f = new TipFragment();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, f);
                ft.commit();
            }
        });

        unitConvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment f = new UnitFragment();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, f);
                ft.commit();
            }
        });

        moneyExchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment f = new MoneyFragment();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, f);
                ft.commit();
            }
        });

    }
}
