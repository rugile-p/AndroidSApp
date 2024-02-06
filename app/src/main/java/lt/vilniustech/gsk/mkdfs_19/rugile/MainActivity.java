package lt.vilniustech.gsk.mkdfs_19.rugile;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.DisplayMetrics;
import android.view.MenuInflater;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import lt.vilniustech.gsk.mkdfs_19.rugile.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    TextView firstFragment, secondFragment, next, previous, choose, jobName, name, summary,
            contacts, mail, exp1, exp2, exp3, exp4, exp1t, exp2t, exp3t, exp4t;
    Menu Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        firstFragment = findViewById(R.id.FirstFragment);
        secondFragment = findViewById(R.id.SecondFragment);
        next = findViewById(R.id.button_first);
        previous = findViewById(R.id.button_second);
        choose = findViewById(R.id.languageSubMenu);
        jobName = findViewById(R.id.textView3);
        name = findViewById(R.id.textView2);
        summary = findViewById(R.id.textView);
        contacts = findViewById(R.id.textView4);
        mail = findViewById(R.id.textView6);
        exp1 = findViewById(R.id.textView10);
        exp2 = findViewById(R.id.textView12);
        exp3 = findViewById(R.id.textView14);
        exp4 = findViewById(R.id.textView16);
        exp1t = findViewById(R.id.textView11);
        exp2t = findViewById(R.id.textView13);
        exp3t = findViewById(R.id.textView17);
        exp4t = findViewById(R.id.textView18);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        Menu = menu;
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                //ietuviu kalba
                setLocale("lt");
                return true;
            case R.id.item2:
                //anglu kalba
                setLocale("en");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void setLocale(String language) {
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, metrics);
        onConfigurationChanged(configuration);
        recreate();
    }

   /* @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        firstFragment.setText(R.string.first_fragment_label);
        secondFragment.setText(R.string.second_fragment_label);
        next.setText(R.string.next);
        previous.setText(R.string.previous);
        choose.setText(R.string.choose_language);
        jobName.setText(R.string.job_name);
        name.setText(R.string.name);
        summary.setText(R.string.summary);
        contacts.setText(R.string.contacts);
        mail.setText(R.string.mail);
        exp1.setText(R.string.exp1);
        exp2.setText(R.string.exp2);
        exp3.setText(R.string.exp3);
        exp4.setText(R.string.exp4);
        exp1t.setText(R.string.exp1t);
        exp2t.setText(R.string.exp2t);
        exp3t.setText(R.string.exp3t);
        exp4t.setText(R.string.exp4t);

        MenuItem item = Menu.findItem(R.id.languageSubMenu);
        item.setTitle(R.string.choose_language);
    }*/

    public void sendMessage(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rugile.peciokaite@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Skelbimas");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Sveiki, ");
        startActivity(Intent.createChooser(emailIntent, ""));
    }
}