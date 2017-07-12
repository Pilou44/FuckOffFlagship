package poc.fuckoffflagship.modules.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BasePresenter;

public class HomeActivity extends BaseActivity implements HomeContract.HomeView {

    //private TextView mMessage;
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private HomePagerAdapter mPagertAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeContract.HomePresenter)mPresenter).onFab1Clicked();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeContract.HomePresenter)mPresenter).onFab2Clicked();
            }
        });

        //mMessage = (TextView) findViewById(R.id.message);
        mTabLayout = (TabLayout) findViewById(R.id.home_tab);

        mPager = (ViewPager) findViewById(R.id.pager);
        mTabLayout.setupWithViewPager(mPager);

        mPagertAdapter = new HomePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagertAdapter);

        mTabLayout.getTabAt(0).setText("Profile");
        mTabLayout.getTabAt(1).setText("Jobs");
        mTabLayout.getTabAt(2).setText("Network");
    }


    @Override
    public int getFragmentId() {
        return findFragmentByPosition(mPager.getCurrentItem()).getId();
    }

    private Fragment findFragmentByPosition(int position) {
        return getSupportFragmentManager().findFragmentByTag(
                "android:switcher:" + mPager.getId() + ":"
                        + mPagertAdapter.getItemId(position));
    }

    @Override
    protected BasePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((HomeContract.HomePresenter)mPresenter).onResume();
    }

    public void updateMessage(String message) {
        //mMessage.setText(message);
    }
}
