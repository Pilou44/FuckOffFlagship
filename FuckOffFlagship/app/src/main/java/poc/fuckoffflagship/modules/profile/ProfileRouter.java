package poc.fuckoffflagship.modules.profile;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

import poc.fuckoffflagship.modules.contactlist.ContactListActivity;
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
    public void showFriendsList(int viewType, int id) {
        switch (viewType) {
            case USE_ACTIVITIES:
                Intent intent = new Intent(mContext, ContactListActivity.class);
                intent.putExtra("id", id);
                mContext.startActivity(intent);
                break;
            case USE_FRAGMENTS:
                FragmentTransaction transaction = mActivity.getFragmentManager().beginTransaction();

                ContactListFragment fragment = new ContactListFragment();
                Bundle args = new Bundle();
                args.putInt("id", id);
                fragment.setArguments(args);
                transaction.replace(mActivity.getFragmentId(), fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }

    }
}
