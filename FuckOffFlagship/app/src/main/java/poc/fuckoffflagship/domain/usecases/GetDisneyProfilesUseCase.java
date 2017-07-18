package poc.fuckoffflagship.domain.usecases;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Disney;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class GetDisneyProfilesUseCase {

    private static GetDisneyProfilesUseCase mInstance;
    private final Context mContext;
    private List<Disney> mDisneyList;

    static public GetDisneyProfilesUseCase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new GetDisneyProfilesUseCase(context);
        }
        return mInstance;
    }

    private GetDisneyProfilesUseCase(Context context) {
        mContext = context;

        mDisneyList = new ArrayList<>();

        String[] names = mContext.getResources().getStringArray(R.array.disney);
        for (String name : names) {
            mDisneyList.add(new Disney(name));
        }
    }

    public List<Disney> execute() {
        return mDisneyList;
    }
}
