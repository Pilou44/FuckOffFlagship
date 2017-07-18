package poc.fuckoffflagship.modules.core;

import android.content.Context;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class BasePresenter {

    protected Object mView;
    protected BaseRouter mRouter;
    protected Context mContext;

    public BasePresenter(Object view) {
        mView = view;
        if (view instanceof BaseActivity) {
            mContext = (Context) view;
        } else if (view instanceof BaseFragment) {
            mContext = ((BaseFragment) view).getContext();
        }
    }
}
