package poc.fuckoffflagship.modules.disneylist;

import android.content.Context;

import java.util.List;

import poc.fuckoffflagship.data.beans.Disney;
import poc.fuckoffflagship.domain.usecases.GetDisneyProfilesUseCase;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class DisneyInteractor implements DisneyContract.Interactor {

    private final GetDisneyProfilesUseCase mDisneyUseCase;

    public DisneyInteractor(Context context) {
        mDisneyUseCase = GetDisneyProfilesUseCase.getInstance(context);
    }

    @Override
    public List<Disney> getAllDisney() {
        return mDisneyUseCase.execute();
    }
}
