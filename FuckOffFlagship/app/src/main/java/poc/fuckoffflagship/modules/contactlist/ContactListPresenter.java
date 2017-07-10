package poc.fuckoffflagship.modules.contactlist;

import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseFragment;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ContactListPresenter extends BasePresenter implements ContactListContract.ContactListPresenter {

    private final ContactListContract.ContactListInteractor mInteractor;
    private int mId;

    public ContactListPresenter(BaseFragment fragment, BaseActivity activity) {
        super(fragment, activity);
        mInteractor = new ContactListInteractor(activity);
    }

    @Override
    public void setId(int id) {
        mId = id;

        String ids[] = mInteractor.getIds(id);
        ((ContactListContract.ContactListView) mFragment).populate(ids);
    }

}
