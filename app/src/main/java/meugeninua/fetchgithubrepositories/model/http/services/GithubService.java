package meugeninua.fetchgithubrepositories.model.http.services;

import meugeninua.fetchgithubrepositories.model.http.entities.GithubAuthorization;
import retrofit2.Call;
import retrofit2.http.POST;

public interface GithubService {

    @POST("/authorization")
    Call<GithubAuthorization> createAuthorization();
}
