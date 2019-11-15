package com.example.vr_engineers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class topic extends AppCompatActivity
{
    GridView grid;
    String name[]={"Android","Java","Php","Hadoop","HTML","Pythan","Ajax","C++","Ruby","MYSQL",".Net","Javascript"},s1;
    ArrayAdapter<String> adapter;
    Integer image[]={R.drawable.and1,R.drawable.java,R.drawable.php,R.drawable.hadoop,R.drawable.html,R.drawable.python
            ,R.drawable.ajax,R.drawable.c,R.drawable.ruby,R.drawable.sql,R.drawable.net,R.drawable.javascript},n1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        getSupportActionBar().hide();


        grid =findViewById(R.id.grid);
        Customtrip gc=new Customtrip(topic.this,name,image);
        grid.setAdapter(gc);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            public void onItemClick(AdapterView<?> adapterView, View view, int m, long l) {

                s1=name[m];
                n1=image[m];
                switch(m)

                {
                    case 0: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);

                        startActivity(i);
                        break;
                    }
                    case 1: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 2: {
                        Intent i = new Intent(topic.this,searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }


                    case 3: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 4: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }


                    case 5: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 6: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 7: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 8: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 9: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 10: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                    case 11: {
                        Intent i = new Intent(topic.this, searchlist.class);
                        i.putExtra("key1",s1);
                        i.putExtra("img",n1);
                        startActivity(i);
                        break;
                    }

                }
            }
        });

    }
}
