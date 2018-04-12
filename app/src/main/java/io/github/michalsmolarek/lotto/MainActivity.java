package io.github.michalsmolarek.lotto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


    TextView textView; // tworzę polę dla widoku, który bedzie przechowywał tekst
    Button button; // tworzę pole, które będzie przechowywało guzik

    @Override
    protected void onCreate(Bundle savedInstanceState) { // metoda uruchamiająca aktywność
        super.onCreate(savedInstanceState); // konstruktor domyślny
        setContentView(R.layout.activity_main); // inicjalizacja widoku - patrz na plik XML ( res > layout > activity_main.xml )

        // podpinam widoki
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        // tworzę metoda nasłuchującą zdarzenie kliknięcia w button / guzik jak zwał
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Integer> arrayList = new ArrayList<Integer>(); // tworzę listę, przechowującą 49 liczb i ją wypełniam

                for (int i = 1; i <= 49; i++) {

                    arrayList.add(i);
                    
                }

                Collections.shuffle(arrayList); // mieszam elementy w liście używająć kolekcji

                ArrayList<Integer> listComplete  = new ArrayList<Integer>(); // tworzę listę, która będzie listą wynikową (6 wylosowanych)

                for (int i = 0; i < 6; i++) {
                    listComplete.add( arrayList.get(i) );
                }

                Collections.sort(listComplete); // sortuję od najmniejszej

                // usuwanie ostatniego przecinka
                StringBuilder sb = new StringBuilder();

                for (int i: listComplete) {
                    sb.append(String.valueOf(i));
                    sb.append(", ");

                }

                // dodaję wylosowane licby do widoku i wyświetlam je
                textView.setText(sb.toString().replaceAll(", $", ""));
            }
        });
    }
}
