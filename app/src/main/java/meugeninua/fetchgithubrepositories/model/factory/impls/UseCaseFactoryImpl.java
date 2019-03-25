package meugeninua.fetchgithubrepositories.model.factory.impls;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import meugeninua.fetchgithubrepositories.BuildConfig;
import meugeninua.fetchgithubrepositories.model.factory.UseCaseFactory;
import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import meugeninua.fetchgithubrepositories.model.usecases.impls.CallUseCase;
import okhttp3.Credentials;

public class UseCaseFactoryImpl implements UseCaseFactory {

    private final GithubService service;

    public UseCaseFactoryImpl(GithubService service) {
        this.service = service;
    }

    @Override
    public Callable<AuthEntity> createAuthUseCase(final String username, final String password) {
        CreateAuthBody body = new CreateAuthBody();
        body.clientId = BuildConfig.GITHUB_CLIENT_ID;
        body.clientSecret = BuildConfig.GITHUB_CLIENT_SECRET;
        body.fingerprint = "";
        body.note = "meugen";
        body.noteUrl = "";
        body.scopes = Collections.singletonList("repo");
        return new CallUseCase<>(service.createAuthorization(body, Credentials.basic(username, password)));
    }

    @Override
    public Callable<List<ReposEntity>> createReposUseCase(final String token) {
        return new CallUseCase<>(service.getRepositories("token " + token, "private"));
    }
}
