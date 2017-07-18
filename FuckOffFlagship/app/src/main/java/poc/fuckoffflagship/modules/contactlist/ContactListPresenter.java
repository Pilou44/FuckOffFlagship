package poc.fuckoffflagship.modules.contactlist;

import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseFragment;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ContactListPresenter extends BasePresenter implements ContactListContract.ContactListPresenter {

    private ContactListContract.ContactListInteractor mInteractor;

    public ContactListPresenter(BaseFragment fragment, BaseActivity activity) {
        super(fragment);
        init(activity);
    }

    public ContactListPresenter(ContactListActivity activity) {
        super(activity);
        init(activity);
    }

    private void init(BaseActivity activity) {
        mInteractor = new ContactListInteractor(activity);
        mRouter = new ContactListRouter(activity);
    }

    @Override
    public void setId(int id) {
        String ids[] = mInteractor.getIds(id);
        ((ContactListContract.ContactListView) mView).populate(ids);
    }

    @Override
    public Profile getProfile(int id) {
        return mInteractor.getProfile(id);
    }

    @Override
    public void onProfileClicked(int viewType, int id) {
        ((ContactListContract.ContactListRouter) mRouter).showProfile(viewType, id);
    }

}
