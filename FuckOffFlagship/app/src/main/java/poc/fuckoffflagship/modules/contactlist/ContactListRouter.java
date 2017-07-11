package poc.fuckoffflagship.modules.contactlist;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseRouter;
import poc.fuckoffflagship.modules.profile.ProfileActivity;
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
    public void showProfile(int viewType, int id) {
        switch (viewType) {
            case USE_FRAGMENTS:
                FragmentTransaction transaction = mActivity.getFragmentManager().beginTransaction();

                ProfileFragment fragment = new ProfileFragment();
                Bundle args = new Bundle();
                args.putInt("id", id);
                fragment.setArguments(args);
                transaction.replace(mActivity.getFragmentId(), fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case USE_ACTIVITIES:
                Intent intent = new Intent(mContext, ProfileActivity.class);
                intent.putExtra("id", id);
                mContext.startActivity(intent);
                break;
        }
    }
}
