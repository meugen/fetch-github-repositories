package meugeninua.fetchgithubrepositories.ui.activities.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.app.di.Injectable;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;
import meugeninua.fetchgithubrepositories.model.usecases.LiveDataTask;
import meugeninua.fetchgithubrepositories.model.usecases.Result;
import meugeninua.fetchgithubrepositories.ui.di.MainComponent;
import meugeninua.fetchgithubrepositories.ui.di.ReposComponent;

public class MainViewModel extends ViewModel implements
        ReposComponent.GithubReposProvider, MainComponent.GithubReposLoader,
        Injectable<AppComponent> {

    private MutableLiveData<Result<List<ReposEntity>>> repositoriesData;

    private GithubRepository githubRepository;
    private Executor executor;

    @Override
    public LiveData<Result<List<ReposEntity>>> getGithubRepositories() {
        return repositoriesData;
    }

    @Override
    public LiveData<Result<List<ReposEntity>>> loadGithubRepositories(final String username, final String password) {
        if (repositoriesData == null) {
            repositoriesData = new MutableLiveData<>();

            Callable<List<ReposEntity>> useCase = new ReposListUseCase(githubRepository, username, password);
            executor.execute(new LiveDataTask<>(useCase, repositoriesData));
        }
        return repositoriesData;
    }

    @Override
    public void inject(final AppComponent appComponent) {
        this.githubRepository = appComponent.provideUseCaseFactory();
        this.executor = appComponent.provideExecutor();
    }
}
