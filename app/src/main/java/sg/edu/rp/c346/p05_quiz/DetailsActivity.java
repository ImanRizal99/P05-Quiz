package sg.edu.rp.c346.p05_quiz;

import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class DetailsActivity extends AppCompatActivity {
    TextView tvSelected;
    TextView tvCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvSelected = findViewById(R.id.textSelected);
        tvCost = findViewById(R.id.textCost);
        Intent intentReceived = getIntent();
        int cost = intentReceived.getIntExtra("cost", 0);
        int count = intentReceived.getIntExtra("count", 0);
        int roundTrip = intentReceived.getIntExtra("RoundTrip",0);
        int result = 0;
        if (roundTrip == 0) {
            result = cost * count;
        }
        else {
            result = cost * count * roundTrip;
        }
        if (roundTrip == 0) {
            tvSelected.setText("You have selected One Way Trip.");
        }
        else {
            tvSelected.setText("You have selected Round Way Trip.");
        }
        tvCost.setText(String.format("Your air ticket costs $%d",result));
    }
}
