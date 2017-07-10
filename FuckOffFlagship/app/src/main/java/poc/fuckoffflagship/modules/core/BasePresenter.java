package poc.fuckoffflagship.modules.core;

import poc.fuckoffflagship.modules.home.HomeActivity;
import poc.fuckoffflagship.modules.home.HomeContract;
import poc.fuckoffflagship.modules.profile.ProfileFragment;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class BasePresenter {

    protected BaseFragment mFragment;
    protected BaseRouter mRouter;
    protected BaseActivity mActivity;

    public BasePresenter(BaseActivity activity) {
        mActivity = activity;
    }


    public BasePresenter(BaseFragment fragment, BaseActivity activity) {
        mFragment = fragment;
        mActivity = activity;
    }
}
