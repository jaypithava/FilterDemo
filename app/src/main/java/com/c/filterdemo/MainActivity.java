package com.c.filterdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillExampleList();
        setUpRecyclerView();
    }
    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.drive, "drive", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.facebook, "facebook", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.gmail, "gmail", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.instagram, "instagram", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.linkedin, "linkedin", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.pin, "pin", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.playstore, "playstore", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.search, "search", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.slides, "slides", "Eighteen"));
        exampleList.add(new ExampleItem(R.drawable.telegram, "telegram", "Eighteen"));
        exampleList.add(new ExampleItem(R.drawable.whatsapp, "whatsapp", "Eighteen"));
        exampleList.add(new ExampleItem(R.drawable.youtube, "youtube", "Eighteen"));
    }
    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}