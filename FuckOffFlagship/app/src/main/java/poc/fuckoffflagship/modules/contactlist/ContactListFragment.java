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
import poc.fuckoffflagship.modules.core.BaseRouter;

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
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mContactListAdapter = new ContactListAdapter(this.getActivity(), (ContactListContract.ContactListPresenter) mPresenter, BaseRouter.USE_FRAGMENTS);
        mRecyclerView.setAdapter(mContactListAdapter);
        int id = getArguments().getInt("id");
        ((ContactListContract.ContactListPresenter) mPresenter).setId(id);

        return view;
    }

    @Override
    protected BasePresenter createPresenter() {
        return new ContactListPresenter(this, (BaseActivity) getActivity());
    }

    @Override
    public void populate(String[] ids) {
        mContactListAdapter.addValues(ids);
    }
}
