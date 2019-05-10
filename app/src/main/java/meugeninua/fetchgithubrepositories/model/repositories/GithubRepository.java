package meugeninua.fetchgithubrepositories.model.repositories;

import java.util.List;
import java.util.concurrent.Callable;

import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;

public interface GithubRepository {

    Callable<AuthEntity> createAuthUseCase(String username, String password);

    Callable<List<ReposEntity>> createReposUseCase(String token);
}
