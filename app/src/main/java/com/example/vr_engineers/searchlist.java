package com.example.vr_engineers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class searchlist extends AppCompatActivity {

    ListView listView;
    ProgressBar progressBar;
    //String HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/android.php";
    String HTTP_JSON_URL2 = "https://studentmanagement924230.000webhostapp.com/vr_engineers/android.php";
    String HTTP_JSON_URL;
    EditText editText;
    List SubjectArrayList = new ArrayList();
    List Sno = new ArrayList();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_searchlist);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setNavigationIcon(R.drawable.back);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().hide();

/*
        if(Build.VERSION.SDK_INT>16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
*/
        ImageView subimg = findViewById(R.id.subimg);
        Bundle im = getIntent().getExtras();
        subimg.setImageResource(im.getInt("img"));


        listView = (ListView) findViewById(R.id.listview1);
       // listView.setTextColor(Color.parseColor("#fe00fb"));
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        editText = (EditText) findViewById(R.id.edittext1);

        // Calling Method to Parese JSON data into listView.
        new GetHttpResponse(searchlist.this).execute();

        // Calling EditText addTextChangedListener method which controls the EditText type sequence.
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //Updating Array Adapter ListView after typing inside EditText.
                searchlist.this.arrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Adding On item click listener on ListView.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO Auto-generated method stub
                //  String value = adapter.getItem(position);
                String s = (String) Sno.get(position);
                String Item = parent.getItemAtPosition(position).toString();

                //   String java = intent.getExtras().getString("Android");

                Intent i = new Intent(searchlist.this, PlayerViewDemoActivity.class);
                //i.putExtra("topicname", java);
                i.putExtra("url", s);
                i.putExtra("key", Item);
                //  i.putExtra("img",n1);
                startActivity(i);

                // Showing ListView click item using Toast message on screen.
                // Toast.makeText(searchlist.this, Item+s, Toast.LENGTH_LONG).show();
            }
        });
    }

    public class GetHttpResponse extends AsyncTask<Void, Void, Void> {
        // Creating context.
        public Context context;

        // Creating string to hold Http response result.
        String ResultHolder;

        // Creating constructor .
        public GetHttpResponse(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Intent intent = getIntent();
            String name = intent.getExtras().getString("key1");
            if (name.equals("Android")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/android.php";
            } else if (name.equals("Java")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/java.php";
            } else if (name.equals("Php")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/php.php";
            }//https://studentmanagement924230.000webhostapp.com/vr_engineers/hadoop.php
            else if (name.equals("Hadoop")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/hadoop.php";
            } else if (name.equals("HTML")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/html.php";
            } else if (name.equals("Pythan")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/pythan.php";
            }
            else if (name.equals("Ajax")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/ajax.php";
            } else if (name.equals("C++")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/c.php";
            }
            else if (name.equals("Ruby")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/ruby.php";
            }
            else if (name.equals("MYSQL")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/sql.php";
            }
            else if (name.equals(".Net")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/net.php";
            } else if (name.equals("Javascript")) {
                HTTP_JSON_URL = "https://studentmanagement924230.000webhostapp.com/vr_engineers/javascript.php";
            }
            // Sending the Http URL into HttpServicesClass to parse JSON.
            HttpServicesClass httpServiceObject = new HttpServicesClass(HTTP_JSON_URL);
            try {
                httpServiceObject.ExecutePostRequest();

                // If the server response code = 200 then JSON parsing start.
                if (httpServiceObject.getResponseCode() == 200) {
                    // Adding Http response into ResultHolder string.
                    ResultHolder = httpServiceObject.getResponse();

                    // If there is response present into ResultHolder.
                    if (ResultHolder != null) {
                        // Creating JSONArray and set it to null.
                        JSONArray jsonArray = null;

                        try {

                            // Adding ResultHolder into JSONArray.
                            jsonArray = new JSONArray(ResultHolder);

                            // Creating JSONObject.
                            JSONObject jsonObject;

                            // Starting for loop at the end of jsonArray length.
                            for (int i = 0; i < jsonArray.length(); i++) {
                                // Adding JSON array object .
                                jsonObject = jsonArray.getJSONObject(i);

                                // Adding the JSON parse object into SubjectArrayList.
                                SubjectArrayList.add(jsonObject.getString("name").toString());
                                Sno.add(jsonObject.getString("url").toString());
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {
                    // If something goes wrong then showing the error message on screen.
                    Toast.makeText(context, httpServiceObject.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        // This block will execute after done all background processing.
        @Override
        protected void onPostExecute(Void result) {
            // Hiding the progress bar after done loading JSON.
            progressBar.setVisibility(View.GONE);

            // Showing the ListView after done loading JSON.
            listView.setVisibility(View.VISIBLE);

            // Setting up the SubjectArrayList into Array Adapter.
            arrayAdapter = new ArrayAdapter(searchlist.this, android.R.layout.simple_list_item_2, android.R.id.text1, SubjectArrayList);

            // Passing the Array Adapter into ListView.
            listView.setAdapter(arrayAdapter);

        }
    }

}