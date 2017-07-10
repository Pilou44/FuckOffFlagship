package poc.fuckoffflagship.modules.home;

import android.content.Context;
import android.content.Intent;

import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseRouter;
import poc.fuckoffflagship.modules.user.UserActivity;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class HomeRouter extends BaseRouter implements HomeContract.HomeRouter{
    public HomeRouter(Context context) {
        super(context);
    }

    @Override
    public void showUserProfile(int id) {
        Intent intent = new Intent(mContext, UserActivity.class);
        intent.putExtra("id", id);
        mContext.startActivity(intent);
    }
}
