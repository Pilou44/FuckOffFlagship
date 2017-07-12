package poc.fuckoffflagship.modules.user;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseRouter;
import poc.fuckoffflagship.modules.profile.ProfileFragment;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class UserRouter extends BaseRouter implements UserContract.UserRouter {

    private BaseActivity mActivity;

    public UserRouter(BaseActivity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public void showProfile(int id) {
        FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();

        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        transaction.add(mActivity.getFragmentId(), fragment);
        transaction.commit();
    }
}
