package poc.fuckoffflagship.modules.home;

import android.widget.Toast;

import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class HomePresenter extends BasePresenter implements HomeContract.HomePresenter {
    public HomePresenter(HomeActivity homeActivity) {
        super(homeActivity);
        mRouter = new HomeRouter(mActivity);
    }

    public void onResume() {
        ((HomeContract.HomeView) mActivity).updateMessage("Fuck Off Flagship");
    }

    public void onFabClicked() {
        Toast.makeText(mActivity, "Presenter Clicked Ok", Toast.LENGTH_LONG).show();

        ((HomeContract.HomeRouter) mRouter).showUserProfile(1);
    }
}
