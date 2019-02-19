package com.example.pankaj.testactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaration

    Toolbar t1;
    DrawerLayout mdrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    ImageButton imgRight;
    GridView gv,drawer_Right;
    Context con=this;
    CustomAdapter cl1,cl2;
    int img[];
    String name[];
    String j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //intisilize

        t1 = findViewById(R.id.toolbar);
        setSupportActionBar(t1);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mdrawerLayout = findViewById(R.id.activity_main);

        gv =findViewById(R.id.main_grid);

        drawer_Right = findViewById(R.id.drawer_right);
        imgRight= findViewById(R.id.imgRight);
        mdrawerLayout.addDrawerListener(mDrawerToggle);

        //Action

        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mdrawerLayout.isDrawerOpen(drawer_Right))
                {
                    mdrawerLayout.closeDrawer(drawer_Right);
                    Toast.makeText(getApplicationContext(),"drawer open",Toast.LENGTH_LONG).show();

                }

                else if(!mdrawerLayout.isDrawerOpen(drawer_Right))
                {
                    mdrawerLayout.openDrawer(drawer_Right);
                    Toast.makeText(getApplicationContext(),"drawer closed",Toast.LENGTH_LONG).show();
                }


            }
        });


        getData();




    }

    public void getData(){
        j = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25";
        name=j.split(",");
        //img = new int[]{R.drawable.one,R.drawable.two1,R.drawable.three,R.drawable.five,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one};
        cl1 = new CustomAdapter(name,con,img);
       // gv.setAdapter(cl1);
        cl2 = new CustomAdapter(name,con,img);
        drawer_Right.setAdapter(cl1);

    }



}
