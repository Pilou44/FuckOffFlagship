package poc.fuckoffflagship.modules.contactlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.modules.core.BaseActivity;
import poc.fuckoffflagship.modules.core.BasePresenter;
import poc.fuckoffflagship.modules.core.BaseRouter;

public class ContactListActivity extends BaseActivity implements ContactListContract.ContactListView {

    private RecyclerView mRecyclerView;
    private ContactListAdapter mContactListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactListAdapter = new ContactListAdapter(this, (ContactListContract.ContactListPresenter) mPresenter, BaseRouter.USE_ACTIVITIES);
        mRecyclerView.setAdapter(mContactListAdapter);
        int id = getIntent().getIntExtra("id", -1);
        ((ContactListContract.ContactListPresenter) mPresenter).setId(id);
    }

    @Override
    protected BasePresenter createPresenter() {
        return new ContactListPresenter(this);
    }

    @Override
    public void populate(String[] ids) {
        mContactListAdapter.addValues(ids);
    }
}
