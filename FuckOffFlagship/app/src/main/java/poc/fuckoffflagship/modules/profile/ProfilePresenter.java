package poc.fuckoffflagship.modules.profile;

import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ProfilePresenter extends BasePresenter implements ProfileContract.ProfilePresenter {

    private final ProfileContract.ProfileInteractor mInteractor;

    public ProfilePresenter(ProfileFragment profileFragment, BaseActivity activity) {
        super(activity);
        mInteractor = new ProfileInteractor();
    }

    @Override
    public void setId(int id) {
        Profile profile = mInteractor.getProfile(id);
    }
}
