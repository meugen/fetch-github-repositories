package meugeninua.fetchgithubrepositories.model.network.services;

import java.util.List;

import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GithubService {

    @POST("/authorizations")
    Call<AuthEntity> createAuthorization(
            @Body CreateAuthBody body,
            @Header("Authorization") String auth);

    @GET("/user/repos")
    Call<List<ReposEntity>> getRepositories(
            @Header("Authorization") String auth,
            @Query("visibility") String visibility);
}
