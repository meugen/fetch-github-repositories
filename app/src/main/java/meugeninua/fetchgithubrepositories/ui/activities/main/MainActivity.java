package meugeninua.fetchgithubrepositories.ui.activities.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import java.util.List;

import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.usecases.Result;
import meugeninua.fetchgithubrepositories.ui.activities.base.BaseActivity;
import meugeninua.fetchgithubrepositories.ui.di.MainComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.content.ContentFragment;
import meugeninua.fetchgithubrepositories.ui.fragments.login.LoginFragment;
import meugeninua.fetchgithubrepositories.ui.fragments.message.MessageFragment;
import meugeninua.fetchgithubrepositories.ui.fragments.progress.ProgressFragment;

public class MainActivity extends BaseActivity<MainComponent>
        implements MainComponent.OnLoginClickListener {

    private static final String TAG_FRAGMENT = "fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT) == null) {
            displayFragment(new LoginFragment());
        }
        LiveData<Result<List<ReposEntity>>> liveData = provideActivityComponent()
                .provideGithubReposProvider().getGithubRepositories();
        observeLiveData(liveData);
    }

    private void displayFragment(final Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, TAG_FRAGMENT)
                .commit();
    }

    @Override
    public void onLoginClick(final String username, final String password) {
        displayFragment(new ProgressFragment());
        LiveData<Result<List<ReposEntity>>> liveData = provideActivityComponent()
                .provideGithubReposLoader().loadGithubRepositories(username, password);
        observeLiveData(liveData);
    }

    private void observeLiveData(final LiveData<Result<List<ReposEntity>>> liveData) {
        if (liveData != null) {
            liveData.observe(this, this::onReposLoaded);
        }
    }

    private void onReposLoaded(final Result<List<ReposEntity>> result) {
        if (result.error != null) {
            displayFragment(MessageFragment.newInstance(result.error.getMessage()));
            return;
        }
        displayFragment(new ContentFragment());
    }

    @Override
    protected MainComponent createActivityComponent(final AppComponent appComponent) {
        return new MainComponentImpl(appComponent, this);
    }
}
