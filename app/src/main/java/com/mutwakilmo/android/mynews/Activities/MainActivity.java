package com.mutwakilmo.android.mynews.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.muddzdev.styleabletoast.StyleableToast;
import com.mutwakilmo.android.mynews.Adapter.ViewPagerAdapter;
import com.mutwakilmo.android.mynews.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    // Class name for Log tag
    public static final String TAG_LOG_MAIN = MainActivity.class.getSimpleName();

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;




    /**
     * Creates the content view and toolbar, sets up the drawer layout and the
     * action bar toggle, and sets up the navigation view.
     *
     * @param savedInstanceState Saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d(TAG_LOG_MAIN, "onCreate: ");

        setActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        setupTabs();


    }

    private void setActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);

    }

    /**
     * Handles the Back button: closes the nav drawer.
     */
    @Override
    public void onBackPressed() {
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }


    /**
     * Inflates the options menu.
     *
     * @param menu Menu to inflate
     * @return Returns true if menu is inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Handles a click on the Settings item in the options menu.
     *
     * @param item Item in options menu that was clicked.
     * @return Returns true if the item was Settings.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_search:
                //Toast.makeText(this, "You Can Search Your Favorite Article", Toast.LENGTH_SHORT).show();
                StyleableToast.makeText(this, "You Can Search Your Favorite Article From MyNews app", R.style.mytoast).show();

                openSearchActivity();
                break;
            case R.id.action_notifications:
               // Toast.makeText(this, "Notifications", Toast.LENGTH_LONG).show();
                StyleableToast.makeText(this, "Notifications From MyNews app", R.style.mytoast).show();
                notificationsActivity();
                break;
            case R.id.action_help:
                //Toast.makeText(this, "Help", Toast.LENGTH_LONG).show();
                StyleableToast.makeText(this, "Help", R.style.mytoast).show();

                helpActivity();
                break;
            case R.id.action_about:
                //Toast.makeText(this, "Action", Toast.LENGTH_LONG).show();
                StyleableToast.makeText(this, "About MyNews app", R.style.mytoast).show();

                aboutActivity();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles a navigation drawer item click. It detects which item was
     * clicked and displays a toast message showing which item.
     *
     * @param item Item in the navigation drawer
     * @return Returns true after closing the nav drawer
     */

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_topstories:
                mViewPager.setCurrentItem(0);
                // Handle the camera import action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.topstories));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Top Stories");
                return true;

            case R.id.nav_mostpopular:
                mViewPager.setCurrentItem(1);
                // Handle the gallery action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.mostpopular));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Most Popular");
                return true;

            case R.id.nav_technology:
                mViewPager.setCurrentItem(2);
                // Handle the slideshow action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.technology));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Technology");
                return true;

            case R.id.nav_business:
                mViewPager.setCurrentItem(3);
                // Handle the tools action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.business));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Business");
                return true;

            case R.id.nav_sports:
                mViewPager.setCurrentItem(4);
                // Handle the share action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.sport));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Sports");
                return true;

            case R.id.nav_travel:
                mViewPager.setCurrentItem(5);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.travel));
                return true;

            case R.id.nav_fashion:
                mViewPager.setCurrentItem(6);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.fashion));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Fashion ");
                return true;

            case R.id.nav_science:
                mViewPager.setCurrentItem(7);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.science));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected:  Science ");
                return true;

            case R.id.nav_automobiles:
                mViewPager.setCurrentItem(8);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.automobiles));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Automobiles");
                return true;
            case R.id.nav_politics:
                mViewPager.setCurrentItem(9);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.politics));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Politics");
                return true;

            case R.id.nav_arts:
                mViewPager.setCurrentItem(10);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.arts));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Arts");
                return true;

            case R.id.nav_world:
                mViewPager.setCurrentItem(11);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.world));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: World");
                return true;

            case R.id.nav_health:
                mViewPager.setCurrentItem(12);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.health));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Health");
                return true;

            case R.id.nav_food:
                mViewPager.setCurrentItem(13);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.food));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Food");
                return true;
            case R.id.nav_movies:
                mViewPager.setCurrentItem(14);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.movies));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Movies");
                return true;
            case R.id.nav_books:
                mViewPager.setCurrentItem(15);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.books));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: Books");
                return true;
            case R.id.nav_realestate:
                mViewPager.setCurrentItem(16);
                // Handle the send action (for now display a toast).
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.realestate));
                Log.d(TAG_LOG_MAIN, "onNavigationItemSelected: realEstate");
                return true;
            default:
                return false;
        }
    }

    /**
     * Displays a toast message.
     *
     * @param message Message to display in toast
     */
    public void displayToast(String message) {
        StyleableToast.makeText(getApplicationContext(), message, R.style.mytoast).show();
    }

    //SetupTabs
    private void setupTabs() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //Open SearchActivity
    private void openSearchActivity() {
        Intent searchActivity = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(searchActivity);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        Log.d(TAG_LOG_MAIN, "openSearchActivity: openSearchActivity");

    }

    //Open AboutActivity
    private void aboutActivity() {
        Intent about = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(about);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        Log.d(TAG_LOG_MAIN, "aboutActivity: OpenAboutActivity");
    }

    //Open HelpActivity
    private void helpActivity() {
        Intent help = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(help);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        Log.d(TAG_LOG_MAIN, "helpActivity: OpenHelpActivity");

    }

    //Open Notifications
    private void notificationsActivity() {
        Intent notifications = new Intent(MainActivity.this, NotificationsActivity.class);
        startActivity(notifications);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        Log.d(TAG_LOG_MAIN, "notificationsActivity: openNotificationsActivity");

    }

    // return to welcome Activity with slide animation
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}