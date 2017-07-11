package poc.fuckoffflagship.modules.profile;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseFragment;
import poc.fuckoffflagship.modules.core.BasePresenter;

public class ProfileFragment extends BaseFragment implements ProfileContract.ProfileView {

    private TextView mName;
    private TextView mLastname;
    private TextView mFunction;
    private TextView mFunctionOs;
    private Button mShowFriendsButton;
    private ImageView mImage;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView();
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mImage = (ImageView) view.findViewById(R.id.image);
        mName = (TextView) view.findViewById(R.id.user_name);
        mLastname = (TextView) view.findViewById(R.id.user_lastname);
        mFunction = (TextView) view.findViewById(R.id.user_function);
        mFunctionOs = (TextView) view.findViewById(R.id.user_function_os);
        mShowFriendsButton = (Button) view.findViewById(R.id.show_friends_button);
        mShowFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileContract.ProfilePresenter) mPresenter).showFriendsList();
            }
        });

        int id = getArguments().getInt("id");
        ((ProfileContract.ProfilePresenter) mPresenter).setId(id);

        return view;
    }

    @Override
    protected BasePresenter createPresenter() {
        return new ProfilePresenter(this, (BaseActivity) getActivity());
    }

    @Override
    public void displayProfile(Profile profile) {
        mName.setText(profile.getName());
        mLastname.setText(profile.getLastname());
        mFunction.setText(profile.getFunction());
        mFunctionOs.setText(profile.getFunctionOs());
        Picasso.with(getActivity()).load(profile.getPictureUrl()).resize(1000, 800).centerInside().into(mImage);
    }
}
