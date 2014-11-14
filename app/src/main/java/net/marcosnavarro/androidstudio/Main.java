package net.marcosnavarro.androidstudio;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class Main extends Activity {

    private EditText editText;
    private ListView listView;
    private RelativeLayout relativeLayout;
    private ArrayList<String> arrayList;
    private TextView no_result;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        listView = (ListView) findViewById(R.id.listView);
        no_result = (TextView) findViewById(R.id.no_result);

        arrayList = new ArrayList<String>();
        arrayList.add("Berlín");
        arrayList.add("Bruselas");
        arrayList.add("Copenhague");
        arrayList.add("Madrid");
        arrayList.add("París");
        arrayList.add("Londres");
        arrayList.add("Roma");
        arrayList.add("Oslo");
        arrayList.add("Ámsterdam");
        arrayList.add("Lisboa");
        arrayList.add("Luxemburgo");
        arrayList.add("Moscú");
        arrayList.add("Bucarest");
        arrayList.add("Berna");
        arrayList.add("Belgrado");
        arrayList.add("Praga");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
                if(adapter.getCount()==0){ no_result.setVisibility(View.VISIBLE); }
                listView.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){ relativeLayout.setVisibility(View.VISIBLE); }
                else{
                    relativeLayout.setVisibility(View.GONE);
                    no_result.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
