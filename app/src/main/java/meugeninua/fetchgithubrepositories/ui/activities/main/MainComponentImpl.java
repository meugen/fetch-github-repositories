package meugeninua.fetchgithubrepositories.ui.activities.main;

import com.google.gson.Gson;

import java.util.concurrent.ExecutorService;

import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.model.Repository;
import meugeninua.fetchgithubrepositories.model.factory.UseCaseFactory;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import meugeninua.fetchgithubrepositories.ui.activities.base.BaseComponentImpl;
import meugeninua.fetchgithubrepositories.ui.activities.main.viewmodel.MainViewModel;
import meugeninua.fetchgithubrepositories.ui.di.MainComponent;
import okhttp3.OkHttpClient;

class MainComponentImpl extends BaseComponentImpl<MainActivity>
        implements MainComponent {

    private MainViewModel viewModel;

    MainComponentImpl(
            final AppComponent appComponent,
            final MainActivity activity) {
        super(appComponent, activity);
    }

    @Override
    public OnLoginClickListener provideLoginClickListener() {
        return provideActivityContext();
    }

    private MainViewModel getMainViewModel() {
        if (viewModel == null) {
            viewModel = getViewModel(MainViewModel.class);
        }
        return viewModel;
    }

    @Override
    public GithubReposProvider provideGithubReposProvider() {
        return getMainViewModel();
    }

    @Override
    public GithubReposLoader provideGithubReposLoader() {
        return getMainViewModel();
    }
}
