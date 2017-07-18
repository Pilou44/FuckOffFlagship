package poc.fuckoffflagship.modules.favorite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseFragment;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends BaseFragment {

    private RecyclerView mRecycler;
    private FavoriteAdapter mDisneyAdapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView();

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        mRecycler = (RecyclerView) view.findViewById(R.id.rv);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mDisneyAdapter = new FavoriteAdapter(this.getActivity(), (FavoriteContract.Presenter) mPresenter);
        mRecycler.setAdapter(mDisneyAdapter);

        EventBus.getDefault().register(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String message) {
        mDisneyAdapter.notifyDataSetChanged();
    };

    @Override
    protected BasePresenter createPresenter() {
        return new FavoritePresenter(this, (BaseActivity) getActivity());
    }
}
