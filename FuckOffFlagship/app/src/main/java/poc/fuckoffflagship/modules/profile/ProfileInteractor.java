package poc.fuckoffflagship.modules.profile;

import android.content.Context;

import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.domain.usecases.GetProfileUseCase;
import poc.fuckoffflagship.modules.core.BaseInteractor;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ProfileInteractor extends BaseInteractor implements ProfileContract.ProfileInteractor {

    private final GetProfileUseCase mGetProfileUseCase;

    public ProfileInteractor(Context context) {
        super(context);
        mGetProfileUseCase = new GetProfileUseCase(context);
    }

    @Override
    public Profile getProfile(int id) {
        return mGetProfileUseCase.execute(id);
    }
}
