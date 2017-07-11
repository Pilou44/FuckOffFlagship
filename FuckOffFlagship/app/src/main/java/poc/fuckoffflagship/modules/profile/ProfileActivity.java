package poc.fuckoffflagship.modules.profile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BasePresenter;

public class ProfileActivity extends BaseActivity implements ProfileContract.ProfileView {

    private TextView mName;
    private TextView mLastname;
    private TextView mFunction;
    private TextView mFunctionOs;
    private Button mShowFriendsButton;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mImage = (ImageView) findViewById(R.id.image);
        mName = (TextView) findViewById(R.id.user_name);
        mLastname = (TextView) findViewById(R.id.user_lastname);
        mFunction = (TextView) findViewById(R.id.user_function);
        mFunctionOs = (TextView) findViewById(R.id.user_function_os);
        mShowFriendsButton = (Button) findViewById(R.id.show_friends_button);
        mShowFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileContract.ProfilePresenter) mPresenter).showFriendsList(ProfileRouter.USE_ACTIVITIES);
            }
        });

        int id = getIntent().getIntExtra("id", -1);
        ((ProfileContract.ProfilePresenter) mPresenter).setId(id);
    }

    @Override
    protected BasePresenter createPresenter() {
        return new ProfilePresenter(this);
    }

    @Override
    public void displayProfile(Profile profile) {
        mName.setText(profile.getName());
        mLastname.setText(profile.getLastname());
        mFunction.setText(profile.getFunction());
        mFunctionOs.setText(profile.getFunctionOs());
        Picasso.with(this).load(profile.getPictureUrl()).resize(1000, 800).centerInside().into(mImage);
    }
}
