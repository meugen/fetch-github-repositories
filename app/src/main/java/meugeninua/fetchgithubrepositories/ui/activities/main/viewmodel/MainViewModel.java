package meugeninua.fetchgithubrepositories.ui.activities.main.viewmodel;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.app.di.Injectable;
import meugeninua.fetchgithubrepositories.model.factory.UseCaseFactory;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.usecases.UseCaseResult;
import meugeninua.fetchgithubrepositories.model.usecases.UseCaseRunner;
import meugeninua.fetchgithubrepositories.ui.di.MainComponent;
import meugeninua.fetchgithubrepositories.ui.di.ReposComponent;

public class MainViewModel extends ViewModel implements
        ReposComponent.GithubReposProvider, MainComponent.GithubReposLoader,
        Injectable<AppComponent> {

    private MutableLiveData<UseCaseResult<List<ReposEntity>>> repositoriesData;

    private UseCaseFactory useCaseFactory;
    private ExecutorService executorService;

    @Override
    public LiveData<UseCaseResult<List<ReposEntity>>> getGithubRepositories() {
        return repositoriesData;
    }

    @Override
    public LiveData<UseCaseResult<List<ReposEntity>>> loadGithubRepositories(final String username, final String password) {
        if (repositoriesData == null) {
            repositoriesData = new MutableLiveData<>();

            Callable<List<ReposEntity>> useCase = new ReposListUseCase(useCaseFactory, username, password);
            executorService.submit(new UseCaseRunner<>(repositoriesData, useCase));
        }
        return repositoriesData;
    }

    @Override
    public void inject(final AppComponent appComponent) {
        this.useCaseFactory = appComponent.provideUseCaseFactory();
        this.executorService = appComponent.provideExecutorService();
    }
}
