package meugeninua.fetchgithubrepositories.ui.activities.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.ui.activities.base.BaseActivity;
import meugeninua.fetchgithubrepositories.ui.di.MainComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.login.LoginFragment;

public class MainActivity extends BaseActivity<MainComponent>
        implements MainComponent.OnLoginClickListener {

    private static final String TAG_LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentByTag(TAG_LOGIN) == null) {
            manager.beginTransaction()
                    .replace(R.id.container, new LoginFragment(), TAG_LOGIN)
                    .commit();
        }
    }

    @Override
    public void onLoginClick(final String username, final String password) {
        Toast.makeText(this, "Logged in with username: " + username, Toast.LENGTH_LONG).show();
    }

    @Override
    protected MainComponent createActivityComponent(final AppComponent appComponent) {
        return new MainComponentImpl(appComponent, this);
    }
}
