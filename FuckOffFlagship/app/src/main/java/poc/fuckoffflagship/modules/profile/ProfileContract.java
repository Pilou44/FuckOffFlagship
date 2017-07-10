package poc.fuckoffflagship.modules.profile;

import poc.fuckoffflagship.data.beans.Profile;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ProfileContract {

    interface ProfileView {

    }

    interface ProfilePresenter {

        void setId(int id);
    }

    interface ProfileRouter {

    }

    interface  ProfileInteractor {

        Profile getProfile(int id);
    }
}
