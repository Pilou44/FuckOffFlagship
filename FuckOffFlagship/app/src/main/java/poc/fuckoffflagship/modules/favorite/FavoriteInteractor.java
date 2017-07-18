package poc.fuckoffflagship.modules.favorite;

import android.content.Context;

import java.util.List;

import poc.fuckoffflagship.data.beans.Disney;
import poc.fuckoffflagship.domain.usecases.GetDisneyProfilesUseCase;
import poc.fuckoffflagship.modules.core.BaseActivity;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class FavoriteInteractor implements FavoriteContract.Interactor {
    private final GetDisneyProfilesUseCase mDisneyUseCase;

    public FavoriteInteractor(Context context) {
        mDisneyUseCase = GetDisneyProfilesUseCase.getInstance(context);
    }

    @Override
    public List<Disney> getAllDisney() {
        return mDisneyUseCase.execute();
    }
}
