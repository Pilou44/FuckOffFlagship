package poc.fuckoffflagship.data.beans;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class Profile {

    private String mName;
    private String mLastname;
    private String mFunction;
    private String mFunctionOs;
    private String mPictureUrl;

    public Profile(String name, String lastname, String function, String functionOs, String url) {
        mName = name;
        mLastname = lastname;
        mFunction = function;
        mFunctionOs = functionOs;
        mPictureUrl = url;
    }

    public String getName() {
        return mName;
    }

    public String getLastname() {
        return mLastname;
    }

    public String getFunction() {
        return mFunction;
    }

    public String getFunctionOs() {
        return mFunctionOs;
    }

    public String getPictureUrl() {
        return mPictureUrl;
    }
}
