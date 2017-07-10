package poc.fuckoffflagship.modules.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BasePresenter;

public class UserActivity extends BaseActivity implements UserContract.UserView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        parseIntent(getIntent());
    }

    @Override
    protected BasePresenter createPresenter() {
        return new UserPresenter(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        parseIntent(intent);
    }

    private void parseIntent(Intent intent) {
        int id = getIntent().getIntExtra("id", -1);
        if (id > -1) {
            ((UserContract.UserPresenter) mPresenter).displayUser(id);
        }
    }

    @Override
    public int getFragmentId() {
        return R.id.fragment;
    }
}
