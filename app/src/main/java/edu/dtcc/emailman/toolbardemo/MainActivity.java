package edu.dtcc.emailman.toolbardemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
// import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You pressed a floating action button!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /*
        final MenuItem searchItem = menu.findItem(R.id.myActionItem);
        final SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);
        */

        // Define the listener
        MenuItemCompat.OnActionExpandListener expandListener =
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Search collapsed", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return true;  // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Search expanded", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return true;  // Return true to expand action view
                    }
                };

        // Get the MenuItem for the action item
        MenuItem actionMenuItem = menu.findItem(R.id.myActionItem);

        // Assign the listener to that action item
        MenuItemCompat.setOnActionExpandListener(actionMenuItem, expandListener);


        return super.onCreateOptionsMenu(menu);

        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action1:
                Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                        "This is Action 1.  Watch the floating action button move out off the way.",
                        Snackbar.LENGTH_SHORT).show();
                return true;

            case R.id.action2:
                Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                        "This is Action 2.  You can right swipe me out off the way.",
                        Snackbar.LENGTH_LONG).show();
                return true;

            case R.id.action3:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Toast messages are toast, use Snackbar instead",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;

            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
