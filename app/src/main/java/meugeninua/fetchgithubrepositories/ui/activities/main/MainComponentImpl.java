package meugeninua.fetchgithubrepositories.ui.activities.main;

import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.ui.activities.base.BaseComponentImpl;
import meugeninua.fetchgithubrepositories.ui.activities.main.viewmodel.MainViewModel;
import meugeninua.fetchgithubrepositories.ui.di.MainComponent;

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
