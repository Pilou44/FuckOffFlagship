package poc.fuckoffflagship.modules.profile;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

import poc.fuckoffflagship.modules.contactlist.ContactListFragment;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseRouter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ProfileRouter extends BaseRouter implements ProfileContract.ProfileRouter {

    private final BaseActivity mActivity;

    public ProfileRouter(BaseActivity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public void showFriendsList(int id) {
        FragmentTransaction transaction = mActivity.getFragmentManager().beginTransaction();

        ContactListFragment fragment = new ContactListFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        transaction.replace(mActivity.getFragmentId(), fragment);
        transaction.commit();
    }
}
