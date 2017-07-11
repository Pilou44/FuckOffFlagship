package poc.fuckoffflagship.modules.contactlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Profile;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter {


    private final Context mContext;
    private final ContactListContract.ContactListPresenter mPresenter;
    private List<Integer> mIds;

    public ContactListAdapter(Context context, ContactListContract.ContactListPresenter presenter) {
        super();
        mContext = context;
        mPresenter = presenter;
        mIds = new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_profile, parent, false);
        ItemProfileViewHolder holder = new ItemProfileViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Profile profile = mPresenter.getProfile(mIds.get(position));
        ((ItemProfileViewHolder) holder).mFirstname.setText(profile.getName());
        ((ItemProfileViewHolder) holder).mLastname.setText(profile.getLastname());
        ((ItemProfileViewHolder) holder).mId = mIds.get(position);
    }

    @Override
    public int getItemCount() {
        return mIds.size();
    }

    void addValues(String[] ids) {
        for (String id : ids) {
            int intId = Integer.valueOf(id.substring(2));
            mIds.add(intId);
        }
    }

    private class ItemProfileViewHolder extends RecyclerView.ViewHolder {
        TextView mFirstname;
        TextView mLastname;
        int mId;

        ItemProfileViewHolder(final View view) {
            super(view);
            mFirstname = (TextView) view.findViewById(R.id.item_user_firstname);
            mLastname = (TextView) view.findViewById(R.id.item_user_lastname);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.onProfileClicked(mId);
                }
            });
        }

    }
}
