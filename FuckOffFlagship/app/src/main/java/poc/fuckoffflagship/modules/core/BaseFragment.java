package poc.fuckoffflagship.modules.core;


import android.support.v4.app.Fragment;

/**
 * Created by Guillaume on 10/07/2017.
 */

public abstract  class BaseFragment extends Fragment {

    protected BasePresenter mPresenter;

    protected void onCreateView() {
        mPresenter = createPresenter();
    }

    protected abstract BasePresenter createPresenter();
}
