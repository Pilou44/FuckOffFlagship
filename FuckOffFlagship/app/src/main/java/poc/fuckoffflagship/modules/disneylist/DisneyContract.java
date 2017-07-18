package poc.fuckoffflagship.modules.disneylist;

import java.util.List;

import poc.fuckoffflagship.data.beans.Disney;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class DisneyContract {

    interface Presenter {

        List<Disney> getDisneyList();
    }

    interface Interactor {

        List<Disney> getAllDisney();
    }

    interface View {

    }
}
