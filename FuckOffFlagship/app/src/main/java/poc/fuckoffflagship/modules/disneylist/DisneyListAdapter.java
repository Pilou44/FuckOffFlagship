package poc.fuckoffflagship.modules.disneylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Disney;

/**
 * Created by Guillaume on 10/07/2017.
 */

public class DisneyListAdapter extends RecyclerView.Adapter {


    private final Context mContext;
    private final DisneyContract.Presenter mPresenter;

    public DisneyListAdapter(Context context, DisneyContract.Presenter presenter) {
        super();
        mContext = context;
        mPresenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_disney, parent, false);
        ItemDisneyProfile holder = new ItemDisneyProfile(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Disney disney = mPresenter.getDisneyList().get(position);
        ((ItemDisneyProfile) holder).mName.setText(disney.getName());
        ((ItemDisneyProfile) holder).mChecked.setChecked(disney.isChecked());
        ((ItemDisneyProfile) holder).mChecked.setTag(disney);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getDisneyList().size();
    }

    private class ItemDisneyProfile extends RecyclerView.ViewHolder {
        TextView mName;
        CheckBox mChecked;

        ItemDisneyProfile(final View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.disney_name);
            mChecked = (CheckBox) view.findViewById(R.id.disney_checked);

            mChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (mChecked.getTag() != null) {
                        ((Disney) mChecked.getTag()).setChecked(isChecked);
                        EventBus.getDefault().post("Disney update");
                    }
                }
            });

        }

    }
}
