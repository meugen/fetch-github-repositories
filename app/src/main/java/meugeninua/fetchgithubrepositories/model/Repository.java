package meugeninua.fetchgithubrepositories.model;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import meugeninua.fetchgithubrepositories.BuildConfig;
import meugeninua.fetchgithubrepositories.model.http.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.http.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.http.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.http.services.GithubService;
import okhttp3.Credentials;

public class Repository {

    private final GithubService service;

    public Repository(final GithubService service) {
        this.service = service;
    }

    public AuthEntity getToken(final String username, final String password) throws IOException {
        CreateAuthBody body = new CreateAuthBody();
        body.clientId = BuildConfig.GITHUB_CLIENT_ID;
        body.clientSecret = BuildConfig.GITHUB_CLIENT_SECRET;
        body.note = "Authorization";
        body.scopes = Collections.singletonList("repos");
        return service.createAuthorization(body, Credentials.basic(username, password))
                .execute().body();
    }

    public List<ReposEntity> getReposList(final String token) throws IOException {
        return service.getRepositories("token " + token, "private")
                .execute().body();
    }
}
