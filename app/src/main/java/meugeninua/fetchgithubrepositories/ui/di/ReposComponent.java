package meugeninua.fetchgithubrepositories.ui.di;

import androidx.lifecycle.LiveData;

import java.util.List;

import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.usecases.Result;

public interface ReposComponent extends ActivityComponent {

    GithubReposProvider provideGithubReposProvider();

    interface GithubReposProvider {

        LiveData<Result<List<ReposEntity>>> getGithubRepositories();
    }
}
