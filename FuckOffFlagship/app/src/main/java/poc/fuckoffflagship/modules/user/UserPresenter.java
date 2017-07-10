package poc.fuckoffflagship.modules.user;

import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class UserPresenter extends BasePresenter implements UserContract.UserPresenter{

    public UserPresenter(UserActivity userActivity) {
        super(userActivity);
        mRouter = new UserRouter(mActivity);
    }

    @Override
    public void displayUser(int id) {
        ((UserContract.UserRouter) mRouter).showProfile(id);
    }
}
