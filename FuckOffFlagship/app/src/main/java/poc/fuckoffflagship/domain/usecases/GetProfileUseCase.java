package poc.fuckoffflagship.domain.usecases;

import android.content.Context;

import java.util.HashMap;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Profile;

/**
 * Created by Guillaume on 11/07/2017.
 */

public class GetProfileUseCase {

    private final Context mContext;
    private final HashMap<Integer, Integer> mIds;

    public GetProfileUseCase(Context context) {
        mContext = context;

        mIds = new HashMap<>();
        mIds.put(1, R.array.id1);
        mIds.put(2, R.array.id2);
        mIds.put(3, R.array.id3);
    }

    public Profile execute(int id) {

        if (id >= 1 && id <= 3) {
            String[] profileTab = mContext.getResources().getStringArray(mIds.get(id));
            return new Profile(profileTab[0], profileTab[1], profileTab[2], profileTab[3], profileTab[4]);
        } else {
            return null;
        }
    }

}
