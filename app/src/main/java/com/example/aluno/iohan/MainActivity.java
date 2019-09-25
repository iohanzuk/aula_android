package com.example.aluno.iohan;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static final String[] CORES = new String[] {"FUSO BR/EUA", "FUSO BR/MUNDO"};
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CORES);
        setListAdapter(adapter);
    }

    protected void onListItemClick (ListView listView, View view, int position, long id)
    {
        super.onListItemClick(listView, view, position, id);
        switch (position) {
            case 0:
                Intent fusoEua = new Intent(this, FusoEuaActivity.class);
                startActivity(fusoEua);
                break;
            case 1:
                Intent fusoMundo = new Intent(this, FusoMundoActivity.class);
                startActivity(fusoMundo);
                break;
        }
    }
}
