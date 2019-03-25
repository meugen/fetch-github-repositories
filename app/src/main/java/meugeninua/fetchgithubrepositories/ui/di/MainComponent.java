package meugeninua.fetchgithubrepositories.ui.di;

import java.util.List;

import androidx.lifecycle.LiveData;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.usecases.UseCaseResult;

public interface MainComponent extends LoginComponent, ReposComponent {

    GithubReposLoader provideGithubReposLoader();

    interface GithubReposLoader {

        LiveData<UseCaseResult<List<ReposEntity>>> loadGithubRepositories(String username, String password);
    }
}
