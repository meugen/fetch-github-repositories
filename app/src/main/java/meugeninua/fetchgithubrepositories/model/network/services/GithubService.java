package meugeninua.fetchgithubrepositories.model.network.services;

import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;
import okhttp3.Call;

public interface GithubService {

    Call createAuthorization(CreateAuthBody body, String auth);

    Call getRepositories(String auth, String visibility);
}
