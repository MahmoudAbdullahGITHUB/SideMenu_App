package com.example.beso.sidemenu_70;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mDrwerList;

    RelativeLayout mDrawerPane;

    private DrawerLayout mDrawerLayout;

    ArrayList<NewItem> mNewItems = new ArrayList<NewItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewItems.add(new NewItem("picture","hussin picture",R.drawable.camera));
        mNewItems.add(new NewItem("location","visite location",R.drawable.jps));
        mNewItems.add(new NewItem("pepole","pepole who know",R.drawable.pepole));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrwerList = (ListView) findViewById(R.id.newList);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNewItems);
        mDrwerList.setAdapter(adapter);

        mDrwerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFormDrawer(position);
            }
        });
    }

    private void selectItemFormDrawer(int position){

        FragmentManager fragmentManager = getFragmentManager();
        if (position==0) {
            Fragment fragment = new PreferencesFragment();

            fragmentManager.beginTransaction()
                    .replace(R.id.mainContent, fragment)
                    .commit();

        }else if (position==1){
            Fragment fragment = new locationfrog();

            fragmentManager.beginTransaction()
                    .replace(R.id.mainContent, fragment)
                    .commit();


        }

        mDrwerList.setItemChecked(position,true);
        setTitle(mNewItems.get(position).mTitle);

        mDrawerLayout.closeDrawer(mDrawerPane);

    }


}
