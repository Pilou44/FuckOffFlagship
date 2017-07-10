package poc.fuckoffflagship.modules.core;

import android.app.Fragment;
import android.os.Bundle;

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
