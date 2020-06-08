package sg.edu.rp.c346.id19032110.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    ListView lvColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAdditem);
        lvColour = findViewById(R.id.listViewColour);

        final ArrayList<String> alColours= new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        final ArrayAdapter<String> aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_color = etElement.getText().toString();
                //alColours.add(new_color);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, new_color);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String colour = alColours.get(position);
                        Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();


            }
        });


    }
}
