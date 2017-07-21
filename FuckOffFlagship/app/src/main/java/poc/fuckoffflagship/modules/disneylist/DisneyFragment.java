package poc.fuckoffflagship.modules.disneylist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BaseFragment;
import poc.fuckoffflagship.modules.core.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisneyFragment extends BaseFragment implements DisneyContract.View {


    private RecyclerView mRecycler;
    private DisneyListAdapter mDisneyAdapter;

    public DisneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disney, container, false);
        super.onCreateView();

        mRecycler = (RecyclerView) view.findViewById(R.id.disney_rv);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mDisneyAdapter = new DisneyListAdapter(this.getActivity(), (DisneyContract.Presenter) mPresenter);
        mRecycler.setAdapter(mDisneyAdapter);
        return view;
    }

    @Override
    protected BasePresenter createPresenter() {
        return new DisneyPresenter(this, (BaseActivity) getActivity());
    }
}
