package poc.fuckoffflagship.modules.contactlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * Created by Guillaume on 10/07/2017.
 */

public class ContactListFragment extends BaseFragment implements ContactListContract.ContactListView {

    private RecyclerView mRecyclerView;
    private ContactListAdapter mContactListAdapter;

    public ContactListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView();
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);

        int id = getArguments().getInt("id");
        ((ContactListContract.ContactListPresenter) mPresenter).setId(id);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mContactListAdapter = new ContactListAdapter(this.getActivity(), (ContactListContract.ContactListPresenter) mPresenter);
        mRecyclerView.setAdapter(mContactListAdapter);

    }

    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter(this, (BaseActivity) getActivity());
    }

    @Override
    public void populate(String[] ids) {

    }
}
