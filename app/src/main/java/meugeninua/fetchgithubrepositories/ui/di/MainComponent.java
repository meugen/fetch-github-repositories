package meugeninua.fetchgithubrepositories.ui.di;

import androidx.lifecycle.LiveData;

import java.util.List;

import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.usecases.Result;

public interface MainComponent extends LoginComponent, ReposComponent {

    GithubReposLoader provideGithubReposLoader();

    interface GithubReposLoader {

        LiveData<Result<List<ReposEntity>>> loadGithubRepositories(String username, String password);
    }
}
