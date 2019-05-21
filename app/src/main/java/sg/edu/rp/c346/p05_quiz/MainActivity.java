package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button submitBtn,minusButton, plusButton;
    TextView counter, validation;
    CheckBox oneWay, roundTrip;

    int count = 1;
    boolean OneWayChecked = false;
    boolean RoundTripChecked = false;

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.OneWay:
                if (checked)
                    OneWayChecked = true;
            else
                OneWayChecked = false;
                break;
            case R.id.RoundTrip:
                if (checked)
                RoundTripChecked = true;
            else
                RoundTripChecked = false;
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = findViewById(R.id.submitButton);
        minusButton = findViewById(R.id.minusButton);
        plusButton = findViewById(R.id.PlusButton);

        counter = findViewById(R.id.counter);
        oneWay = findViewById(R.id.OneWay);
        roundTrip = findViewById(R.id.RoundTrip);

        validation = findViewById(R.id.validationText);

        counter.setText(Integer.toString(count));

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    count = count - 1;
                    counter.setText(Integer.toString(count));
                }
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                counter.setText(Integer.toString(count));
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OneWayChecked && RoundTripChecked) {
                    validation.setText("Please choose one trip type only");
                }
                else if (!OneWayChecked && !RoundTripChecked) {
                    validation.setText("Please choose at least one trip type");
                }
                else {
                    validation.setText("");
                    Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                    intent.putExtra("cost", 100);
                    intent.putExtra("count", count);
                    if (RoundTripChecked) {
                        intent.putExtra("RoundTrip", 2);
                    }
                    startActivity(intent);
                }

            }
        });


    }
}
