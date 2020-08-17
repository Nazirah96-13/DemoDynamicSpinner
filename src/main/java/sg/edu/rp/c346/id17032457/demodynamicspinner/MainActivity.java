package sg.edu.rp.c346.id17032457.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //Declare the variables
    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bind/Link the variables to the respective UI elements
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate= findViewById(R.id.buttonUpdate);

        //Initialise the Array List
        alNumbers = new ArrayList<>();

        /* This is Approach 1: Add to the ArrayList directly
        alNumbers.add("2");
        alNumbers.add("4");
       alNumbers.add("6");

       */

        // This is Approach 2: Load it from the string array defined earlier
        //Get the string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        //Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));


        //Create an ArrayAdapter using the default spinner layout
        aaNumbers = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alNumbers);

        //Bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaNumbers);

        //Implement the button onClick () method
        // to load the correct number list when it is clicked

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                //Apply either of the two approaches
                // to load the correct number list based on the selection of spn1

                //Point A
                if(pos==0){
                    String [] strNumbers = getResources().getStringArray(R.array.even_numbers);

                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));

                }else{
                        //Get the string-array and store as an Array
                        String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);

                        //Convert Array to List and add to the ArrayList
                        alNumbers.addAll(Arrays.asList(strNumbers));

                    }
                   aaNumbers.notifyDataSetChanged();
            }
        });

        //Automatic Update of the Spinner
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] strNumbers;
                switch (position){

                    case 0:
                        // Your code for item 1 selected
                        strNumbers = getResources().getStringArray(R.array.even_numbers);
                        break;
                    case 1:
                        // Your code for item 1 selected
                        strNumbers = getResources().getStringArray(R.array.odd_numbers);
                        aaNumbers.notifyDataSetChanged();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
