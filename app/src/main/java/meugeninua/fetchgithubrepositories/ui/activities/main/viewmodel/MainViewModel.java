package meugeninua.fetchgithubrepositories.ui.activities.main.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import meugeninua.fetchgithubrepositories.model.entities.GithubRepository;
import meugeninua.fetchgithubrepositories.ui.di.MainComponent;
import meugeninua.fetchgithubrepositories.ui.di.ReposComponent;

public class MainViewModel extends ViewModel
        implements ReposComponent.GithubReposProvider, MainComponent.GithubReposLoader {

    private final MutableLiveData<List<GithubRepository>> repositoriesData = new MutableLiveData<>();

    @Override
    public LiveData<List<GithubRepository>> getGithubRepositories() {
        return repositoriesData;
    }

    @Override
    public void loadGithubRepositories(final String username, final String password) {

    }
}
