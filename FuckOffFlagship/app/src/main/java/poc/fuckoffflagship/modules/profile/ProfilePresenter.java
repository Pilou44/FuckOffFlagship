package poc.fuckoffflagship.modules.profile;

import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ProfilePresenter extends BasePresenter implements ProfileContract.ProfilePresenter {

    private final ProfileContract.ProfileInteractor mInteractor;
    private int mId;

    public ProfilePresenter(ProfileFragment profileFragment, BaseActivity activity) {
        super(profileFragment, activity);
        mInteractor = new ProfileInteractor(activity);
        mRouter = new ProfileRouter(activity);
    }

    @Override
    public void setId(int id) {
        mId = id;
        Profile profile = mInteractor.getProfile(id);
        ((ProfileContract.ProfileView) mFragment).displayProfile(profile);
    }

    @Override
    public void showFriendsList() {
        ((ProfileContract.ProfileRouter) mRouter).showFriendsList(mId);
    }
}
