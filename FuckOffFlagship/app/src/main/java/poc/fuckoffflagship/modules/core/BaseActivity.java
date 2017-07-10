package poc.fuckoffflagship.modules.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Guillaume on 10/07/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected BasePresenter mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    protected abstract BasePresenter createPresenter();
}
