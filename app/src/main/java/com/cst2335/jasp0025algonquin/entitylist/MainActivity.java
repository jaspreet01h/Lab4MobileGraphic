package com.cst2335.jasp0025algonquin.entitylist;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Entity> entityList;    // List of entities
    private EntityAdapter entityAdapter;     // Custom adapter for ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this layout exists

        // Bind the ListView with the layout
        ListView listView = findViewById(R.id.entity_list);
        entityList = new ArrayList<>();
        entityAdapter = new EntityAdapter(this, entityList) {
            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return null;
            }

            @Override
            public int getItemViewType(int i) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int i) {
                return false;
            }
        };
        listView.setAdapter(entityAdapter);  // Set the adapter for the ListView

        // Load the JSON data from the assets folder
        loadJsonData();
    }

    /**
     * Method to load data from entities.json file in assets
     */
    private void loadJsonData() {
        try {
            // Open the entities.json file from the assets folder
            InputStream inputStream = getAssets().open("entities.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            // Convert bytes to a string with UTF-8 encoding
            String jsonString = new String(buffer, StandardCharsets.UTF_8);

            // Parse the JSON data
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extract data for each entity from the JSON
                int type = jsonObject.getInt("type");
                String name = jsonObject.getString("name");
                String textType = jsonObject.getString("text_type");

                // Create an Entity object and add it to the entityList
                entityList.add(new Entity(type, name, textType));
            }

            // Notify the adapter that the data has changed to update the ListView
            entityAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            // If an error occurs, print stack trace and show a toast
            e.printStackTrace();
            Toast.makeText(this, "Error loading JSON data", Toast.LENGTH_SHORT).show();
            Log.e("MainActivity", "Error parsing JSON: " + e.getMessage());
        }
    }

    private abstract class EntityAdapter implements ListAdapter {
        public EntityAdapter(MainActivity mainActivity, ArrayList<Entity> entityList) {
        }

        public void notifyDataSetChanged() {

        }
    }
}
