package poc.fuckoffflagship.modules.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import poc.fuckoffflagship.modules.disneylist.DisneyFragment;
import poc.fuckoffflagship.modules.favorite.FavoriteFragment;
import poc.fuckoffflagship.modules.profile.ProfileFragment;

class HomePagerAdapter extends FragmentPagerAdapter {

    static final int NUM_ITEMS = 3;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return getProfileFragment();
            case 1:
                return new DisneyFragment();
            case 2:
                return new FavoriteFragment();
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    private Fragment getProfileFragment() {
        Fragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt("id", 1);
        fragment.setArguments(args);
        return fragment;
    }
}
