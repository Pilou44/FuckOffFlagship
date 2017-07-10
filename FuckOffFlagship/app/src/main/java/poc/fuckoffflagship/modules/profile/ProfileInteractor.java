package poc.fuckoffflagship.modules.profile;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseInteractor;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ProfileInteractor extends BaseInteractor implements ProfileContract.ProfileInteractor {

    private Map<Integer, Integer> mIds;

    public ProfileInteractor(Context context) {
        super(context);

        mIds = new HashMap<>();
        mIds.put(1, R.array.id1);
        mIds.put(2, R.array.id2);
        mIds.put(3, R.array.id3);
    }

    @Override
    public Profile getProfile(int id) {
        if (id >= 1 && id <= 3) {
            String[] profileTab = mContext.getResources().getStringArray(mIds.get(id));
            return new Profile(profileTab[0], profileTab[1], profileTab[2], profileTab[3]);
        } else {
            return null;
        }
    }
}
