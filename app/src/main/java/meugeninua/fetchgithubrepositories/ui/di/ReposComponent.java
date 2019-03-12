package meugeninua.fetchgithubrepositories.ui.di;

import java.util.List;

import androidx.lifecycle.LiveData;
import meugeninua.fetchgithubrepositories.model.http.entities.ReposEntity;

public interface ReposComponent extends ActivityComponent {

    GithubReposProvider provideGithubReposProvider();

    interface GithubReposProvider {

        LiveData<List<ReposEntity>> getGithubRepositories();
    }
}
