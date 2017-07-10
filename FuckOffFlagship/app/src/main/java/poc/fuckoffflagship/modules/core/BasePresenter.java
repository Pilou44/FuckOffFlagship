package poc.fuckoffflagship.modules.core;

import poc.fuckoffflagship.modules.home.HomeActivity;
import poc.fuckoffflagship.modules.home.HomeContract;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class BasePresenter {

    protected BaseActivity mActivity;

    public BasePresenter(BaseActivity activity) {
        mActivity = activity;
    }

}
