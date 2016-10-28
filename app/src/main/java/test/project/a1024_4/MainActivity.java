package test.project.a1024_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    Spinner spin2;
    String Spurs[] = {"Mills","Anderson","Lee","Bertans","Dedmon","Simmons"};
    String citys[] = {"台北","桃園","台中"};
    String codes[] = {"02","03","04"};
    ArrayAdapter<String> adapter;
    ArrayList<Map<String,String>> mylist;
    SimpleAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, Spurs);
        spin.setAdapter(adapter);

        // ===========================
        spin2 = (Spinner) findViewById(R.id.spinner2);
        mylist = new ArrayList<>();
        int len=citys.length;
        for(int i=0;i<len;i++)
        {
            HashMap<String,String> m1 = new HashMap<>();
            m1.put("city",citys[i]);
            m1.put("code",codes[i]);
            mylist.add(m1);
        }
        adapter2 = new SimpleAdapter(MainActivity.this,
                mylist,
                //android.R.layout.simple_list_item_2,
                R.layout.myitem,
                new String[]{"city","code"},
                //new int[] {android.R.id.text1,android.R.id.text2}
                new int[] {R.id.myCity,R.id.myCode}
        );
        spin2.setAdapter(adapter2);
    }
}
