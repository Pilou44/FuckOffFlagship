package poc.fuckoffflagship.modules.favorite;

import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;

import poc.fuckoffflagship.data.beans.Disney;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class FavoriteContract {

    interface Presenter {

        List<Disney> getDisneyList();

        List<Disney> getCheckedDisneyList();
    }

    interface Interactor {

        List<Disney> getAllDisney();
    }

    interface View {

    }

}
