package poc.fuckoffflagship.modules.disneylist;

import android.support.v4.app.FragmentActivity;

import java.util.List;

import poc.fuckoffflagship.data.beans.Disney;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class DisneyPresenter extends BasePresenter implements DisneyContract.Presenter {

    private final DisneyContract.Interactor mInteractor;

    public DisneyPresenter(DisneyFragment fragment, BaseActivity activity) {
        super(fragment, activity);
        mInteractor = new DisneyInteractor(activity);
    }

    @Override
    public List<Disney> getDisneyList() {
        return mInteractor.getAllDisney();
    }
}
