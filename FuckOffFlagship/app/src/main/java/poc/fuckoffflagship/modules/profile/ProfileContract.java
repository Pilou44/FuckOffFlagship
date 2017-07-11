package poc.fuckoffflagship.modules.profile;

import poc.fuckoffflagship.data.beans.Profile;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ProfileContract {

    interface ProfileView {
        void displayProfile(Profile profile);
    }

    interface ProfilePresenter {

        void setId(int id);

        void showFriendsList(int viewType);
    }

    interface ProfileRouter {

        void showFriendsList(int viewType, int id);
    }

    interface  ProfileInteractor {

        Profile getProfile(int id);
    }
}
