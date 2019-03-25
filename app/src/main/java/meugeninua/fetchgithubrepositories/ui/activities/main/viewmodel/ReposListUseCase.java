package meugeninua.fetchgithubrepositories.ui.activities.main.viewmodel;

import java.util.List;
import java.util.concurrent.Callable;

import meugeninua.fetchgithubrepositories.model.factory.UseCaseFactory;
import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;

class ReposListUseCase implements Callable<List<ReposEntity>> {

    private final UseCaseFactory useCaseFactory;
    private final String username;
    private final String password;

    ReposListUseCase(
            final UseCaseFactory useCaseFactory,
            final String username, final String password) {
        this.useCaseFactory = useCaseFactory;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<ReposEntity> call() throws Exception {
        AuthEntity authEntity = useCaseFactory.createAuthUseCase(username, password).call();
        return useCaseFactory.createReposUseCase(authEntity.token).call();
    }
}
