package com.projectbp3.appcookbook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.projectbp3.appcookbook.databinding.ActivityHomepage1Binding;

public class Homepage1 extends AppCompatActivity {

    ActivityHomepage1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomepage1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EdgeToEdge.enable(this);

        // Set default fragment on launch
        replaceFragment(new Homepage2());

        binding.navView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.explore) {
                selectedFragment = new Homepage2();
            } else if (item.getItemId() == R.id.saved) {
                selectedFragment = new Saved();
            } else if (item.getItemId() == R.id.profil) {
                selectedFragment = new Profil();
            }

            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }

            return true;
        });


        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            binding.navView.setPadding(0, 0, 0, systemBars.bottom);
            return insets;
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
