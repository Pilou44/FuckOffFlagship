package poc.fuckoffflagship.modules.favorite;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Disney;
import poc.fuckoffflagship.modules.disneylist.DisneyListAdapter;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class FavoriteAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private final FavoriteContract.Presenter mPresenter;

    public FavoriteAdapter(Context context, FavoriteContract.Presenter presenter) {
        super();
        mContext = context;
        mPresenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_favorite_disney, parent, false);
        FavoriteAdapter.ItemDisneyProfile holder = new FavoriteAdapter.ItemDisneyProfile(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Disney disney = mPresenter.getCheckedDisneyList().get(position);
        ((FavoriteAdapter.ItemDisneyProfile) holder).mName.setText(disney.getName());
    }

    @Override
    public int getItemCount() {
        return mPresenter.getCheckedDisneyList().size();
    }


    private class ItemDisneyProfile extends RecyclerView.ViewHolder {
        TextView mName;

        ItemDisneyProfile(final View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.disney_name);

        }
    }
}
