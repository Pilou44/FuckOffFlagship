package poc.fuckoffflagship.modules.user;

import android.app.FragmentTransaction;
import android.os.Bundle;

import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.profile.ProfileFragment;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class UserRouter implements UserContract.UserRouter {

    private BaseActivity mActivity;

    @Override
    public void showProfile(int id) {
        FragmentTransaction transaction = mActivity.getFragmentManager().beginTransaction();

        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        transaction.add(mActivity.getFragmentId(), fragment);
        transaction.commit();
    }

    @Override
    public void setActivity(BaseActivity activity) {
        mActivity = activity;
    }
}
