package poc.fuckoffflagship.modules.contactlist;

import android.content.Context;

import java.util.HashMap;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.domain.usecases.GetProfileUseCase;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseInteractor;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ContactListInteractor extends BaseInteractor implements ContactListContract.ContactListInteractor{

    private final HashMap<Integer, Integer> mIds;
    private final GetProfileUseCase mGetProfileUseCase;

    public ContactListInteractor(Context context) {
        super(context);
        mGetProfileUseCase = new GetProfileUseCase(context);

        mIds = new HashMap<>();
        mIds.put(1, R.array.friends1);
        mIds.put(2, R.array.friends2);
        mIds.put(3, R.array.friends3);
    }

    @Override
    public String[] getIds(int id) {
        if (id >= 1 && id <= 3) {
            return mContext.getResources().getStringArray(mIds.get(id));
        } else {
            return null;
        }
    }

    @Override
    public Profile getProfile(int id) {
        return mGetProfileUseCase.execute(id);
    }
}
