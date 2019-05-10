package meugeninua.fetchgithubrepositories.ui.activities.main.viewmodel;

import java.util.List;
import java.util.concurrent.Callable;

import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;

class ReposListUseCase implements Callable<List<ReposEntity>> {

    private final GithubRepository githubRepository;
    private final String username;
    private final String password;

    ReposListUseCase(
            final GithubRepository githubRepository,
            final String username, final String password) {
        this.githubRepository = githubRepository;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<ReposEntity> call() throws Exception {
        AuthEntity authEntity = githubRepository.createAuthUseCase(username, password).call();
        return githubRepository.createReposUseCase(authEntity.token).call();
    }
}
