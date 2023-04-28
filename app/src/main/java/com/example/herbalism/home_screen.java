package com.example.herbalism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class home_screen extends AppCompatActivity implements View.OnClickListener {

    CardView c1,c2,c3,c4;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        MaterialToolbar toolbar=findViewById(R.id.topAppbar);
        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);

        c1=findViewById(R.id.card_1);
        c2=findViewById(R.id.card_2);
        c3=findViewById(R.id.card_3);
        c4=findViewById(R.id.card_4);
        builder = new AlertDialog.Builder(this);


        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);





        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);
                drawer.openDrawer(GravityCompat.START);
                switch (id) {
                    case R.id.nav_home:
                        Intent intent=new Intent(getApplicationContext(),home_screen.class);
                        startActivity(intent);
                        Toast.makeText(home_screen.this, "Welcome Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_oil:
                        Intent intent5=new Intent(getApplicationContext(),oil.class);
                        startActivity(intent5);
                        break;

                    case R.id.nav_med:
                        Intent intent6=new Intent(getApplicationContext(),med.class);
                        startActivity(intent6);
                        break;

                    case R.id.nav_care:
                        Intent intent3=new Intent(getApplicationContext(),care.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_book:
                        Intent intent4 = new Intent(getApplicationContext(),book.class);
                        startActivity(intent4);
                        break;

                    case R.id.log_out:
                        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                        builder.setMessage("Do you want to log-out?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                        Toast.makeText(getApplicationContext(), "Logged out",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.setTitle("Log-Out");
                        alert.show();
                        break;

                    case R.id.rate:
                        Intent intent1=new Intent(getApplicationContext(),Rating.class);
                        startActivity(intent1);
                        Toast.makeText(home_screen.this, "Give Ratings", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.feedback:
                        Intent intent2=new Intent(getApplicationContext(),Feedback.class);
                        startActivity(intent2);
                        Toast.makeText(getApplicationContext(), "Thanks for Feedback", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        return true;

                }
                return true;
            }
        });

    }

private void replaceFragment(Fragment fragment)
{
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.framelayout,fragment);
    fragmentTransaction.commit();
}


    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId())
        {
            case R.id.card_1:
                Intent intent3=new Intent(getApplicationContext(),oil.class);
                startActivity(intent3);
                break;

            case R.id.card_2:
                Intent intent2=new Intent(getApplicationContext(),med.class);
                startActivity(intent2);
                break;

            case R.id.card_3:
                Intent intent=new Intent(getApplicationContext(),care.class);
                startActivity(intent);
                break;

            case R.id.card_4:
                Intent intent1=new Intent(getApplicationContext(),book.class);
                startActivity(intent1);
                break;
        }
    }
}