package poc.fuckoffflagship.modules.core;

import android.content.Context;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class BasePresenter {

    protected Object mView;
    protected BaseRouter mRouter;
    protected Context mContext;

    public BasePresenter(BaseActivity activity) {
        mView = activity;
        mContext = activity;
    }


    public BasePresenter(BaseFragment fragment, BaseActivity activity) {
        mView = fragment;
        mContext = activity;
    }
}
