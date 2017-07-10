package poc.fuckoffflagship.modules.profile;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseFragment;
import poc.fuckoffflagship.modules.core.BasePresenter;

public class ProfileFragment extends BaseFragment implements ProfileContract.ProfileView {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        int id = getArguments().getInt("id");
        ((ProfileContract.ProfilePresenter) mPresenter).setId(id);

        return view;
    }

    @Override
    protected BasePresenter createPresenter() {
        return new ProfilePresenter(this, (BaseActivity) getActivity());
    }
}
