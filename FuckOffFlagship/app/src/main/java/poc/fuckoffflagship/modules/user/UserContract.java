package poc.fuckoffflagship.modules.user;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class UserContract {
    interface UserView {

    }

    interface UserPresenter {
        void displayUser(int id);
    }

    interface UserInteractor {

    }

    interface UserRouter {
        void showProfile(int id);

    }
}
