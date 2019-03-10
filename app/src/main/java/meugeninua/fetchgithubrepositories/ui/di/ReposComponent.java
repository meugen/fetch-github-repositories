package meugeninua.fetchgithubrepositories.ui.di;

import java.util.List;

import androidx.lifecycle.LiveData;
import meugeninua.fetchgithubrepositories.model.entities.GithubRepository;

public interface ReposComponent extends ActivityComponent {

    GithubReposProvider provideGithubReposProvider();

    interface GithubReposProvider {

        LiveData<List<GithubRepository>> getGithubRepositories();
    }
}
