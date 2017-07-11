package poc.fuckoffflagship.modules.home;

import android.widget.Toast;

import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class HomePresenter extends BasePresenter implements HomeContract.HomePresenter {
    public HomePresenter(HomeActivity homeActivity) {
        super(homeActivity);
        mRouter = new HomeRouter(mContext);
    }

    public void onResume() {
        ((HomeContract.HomeView) mView).updateMessage("Fuck Off Flagship");
    }

    public void onFab1Clicked() {
        Toast.makeText(mContext, "Presenter Clicked Ok  --> Activity", Toast.LENGTH_LONG).show();

        ((HomeContract.HomeRouter) mRouter).showUserProfile(HomeRouter.USE_ACTIVITIES, 1);
    }

    public void onFab2Clicked() {
        Toast.makeText(mContext, "Presenter Clicked Ok --> Fragment", Toast.LENGTH_LONG).show();

        ((HomeContract.HomeRouter) mRouter).showUserProfile(HomeRouter.USE_FRAGMENTS, 1);
    }
}
