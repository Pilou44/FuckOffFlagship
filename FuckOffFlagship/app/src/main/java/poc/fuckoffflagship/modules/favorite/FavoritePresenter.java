package poc.fuckoffflagship.modules.favorite;

import java.util.ArrayList;
import java.util.List;

import poc.fuckoffflagship.data.beans.Disney;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseFragment;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class FavoritePresenter extends BasePresenter implements FavoriteContract.Presenter {
    private final FavoriteContract.Interactor mInteractor;

    public FavoritePresenter(BaseFragment fragment, BaseActivity activity) {
        super(fragment);
        mInteractor = new FavoriteInteractor(activity);
    }

    @Override
    public List<Disney> getDisneyList() {
        return mInteractor.getAllDisney();
    }

    @Override
    public List<Disney> getCheckedDisneyList() {
        List<Disney> selected = new ArrayList<>();
        List<Disney> list = getDisneyList();
        for (int i = 0 ; i < list.size() ; i++) {
            if (list.get(i).isChecked()) {
                selected.add(list.get(i));
            }
        }
        return selected;
    }
}
