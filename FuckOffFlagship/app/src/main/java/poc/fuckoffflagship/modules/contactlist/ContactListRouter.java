package poc.fuckoffflagship.modules.contactlist;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseRouter;
import poc.fuckoffflagship.modules.profile.ProfileFragment;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ContactListRouter extends BaseRouter implements ContactListContract.ContactListRouter {

    private final BaseActivity mActivity;

    public ContactListRouter(BaseActivity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public void showProfile(int id) {
        FragmentTransaction transaction = mActivity.getFragmentManager().beginTransaction();

        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        transaction.replace(mActivity.getFragmentId(), fragment);
        transaction.commit();
    }
}
