package vn.edu.usth.newsreaderonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class NewsReaderOnlineActivity extends AppCompatActivity {
    static boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_reader_online);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        running = true;
        tabLayout.addTab(tabLayout.newTab().setText("Hot"));
        tabLayout.addTab(tabLayout.newTab().setText("Politics"));
        tabLayout.addTab(tabLayout.newTab().setText("Entertainment"));
        tabLayout.addTab(tabLayout.newTab().setText("Economy"));
        tabLayout.addTab(tabLayout.newTab().setText("Technology"));
        tabLayout.addTab(tabLayout.newTab().setText("Crime"));
        tabLayout.addTab(tabLayout.newTab().setText("Sport"));
        tabLayout.addTab(tabLayout.newTab().setText("Education"));
        MainMenuFragment mainMenuFragment = new MainMenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainMenu, mainMenuFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.botNavigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                if (item.getItemId() == R.id.BotNavHome && running == true){
                    return true;
                }else if(item.getItemId() == R.id.BotNavSettings){
                    Intent intent = new Intent(NewsReaderOnlineActivity.this, SettingActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }
        });


        }
    @Override
    public void onStart(){
        super.onStart();
        running = true;
    }
    @Override
    public void onStop(){
        super.onStop();
        running = false;
    }
}
