package meugeninua.fetchgithubrepositories.model.http.services;

import java.util.List;

import meugeninua.fetchgithubrepositories.model.http.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.http.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.http.entities.ReposEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GithubService {

    @POST("/authorization")
    Call<AuthEntity> createAuthorization(
            @Body CreateAuthBody body,
            @Header("Authorization") String auth);

    @GET("/user/repos")
    Call<List<ReposEntity>> getRepositories(
            @Header("Authorization") String auth,
            @Query("visibility") String visibility);
}
