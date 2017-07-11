package poc.fuckoffflagship.modules.home;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class HomeContract {

    interface HomeView {
        void updateMessage(String string);
    }

    interface HomePresenter {
        void onResume();
        void onFab1Clicked();
        void onFab2Clicked();
    }

    interface HomeInteractor {

    }

    interface HomeRouter {

        void showUserProfile(int viewType, int id);
    }
}
