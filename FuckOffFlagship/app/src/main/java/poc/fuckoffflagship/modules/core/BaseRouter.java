package poc.fuckoffflagship.modules.core;

import android.content.Context;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class BaseRouter {
    public static final int USE_ACTIVITIES = 0;
    public static final int USE_FRAGMENTS = 1;

    protected final Context mContext;

    public BaseRouter(Context context) {
        mContext = context;
    }
}
