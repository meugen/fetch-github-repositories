package meugeninua.fetchgithubrepositories.ui.di;

import java.util.List;

import androidx.lifecycle.LiveData;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.usecases.UseCaseResult;

public interface ReposComponent extends ActivityComponent {

    GithubReposProvider provideGithubReposProvider();

    interface GithubReposProvider {

        LiveData<UseCaseResult<List<ReposEntity>>> getGithubRepositories();
    }
}
