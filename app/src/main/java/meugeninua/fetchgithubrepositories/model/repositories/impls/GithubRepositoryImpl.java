package meugeninua.fetchgithubrepositories.model.repositories.impls;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import meugeninua.fetchgithubrepositories.BuildConfig;
import meugeninua.fetchgithubrepositories.model.json.readers.EntityReader;
import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;
import meugeninua.fetchgithubrepositories.model.usecases.impls.CallUseCase;
import okhttp3.Call;
import okhttp3.Credentials;

public class GithubRepositoryImpl implements GithubRepository {

    private final GithubService service;
    private final EntityReader<AuthEntity> authEntityReader;
    private final EntityReader<List<ReposEntity>> reposEntitiesReader;

    public GithubRepositoryImpl(
            final GithubService service,
            final EntityReader<AuthEntity> authEntityReader,
            final EntityReader<List<ReposEntity>> reposEntitiesReader) {
        this.service = service;
        this.authEntityReader = authEntityReader;
        this.reposEntitiesReader = reposEntitiesReader;
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
        Call call = service.createAuthorization(body, Credentials.basic(username, password));

        return new CallUseCase<>(call, authEntityReader);
    }

    @Override
    public Callable<List<ReposEntity>> createReposUseCase(final String token) {
        Call call = service.getRepositories("token " + token, "private");
        return new CallUseCase<>(call, reposEntitiesReader);
    }
}
