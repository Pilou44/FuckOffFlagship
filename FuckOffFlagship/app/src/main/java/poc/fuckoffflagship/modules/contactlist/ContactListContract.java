package poc.fuckoffflagship.modules.contactlist;

import poc.fuckoffflagship.data.beans.Profile;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ContactListContract {

    interface ContactListView {
        void populate(String[] ids);
    }

    interface ContactListPresenter {
        void setId(int id);

        Profile getProfile(int id);

        void onProfileClicked(int id);
    }

    interface ContactListInteractor {

        String[] getIds(int id);

        Profile getProfile(int id);
    }

    interface ContactListRouter {

        void showProfile(int id);
    }
}
