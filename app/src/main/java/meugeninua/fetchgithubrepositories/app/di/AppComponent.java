package meugeninua.fetchgithubrepositories.app.di;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;

import java.util.List;
import java.util.concurrent.Executor;

import meugeninua.fetchgithubrepositories.model.json.readers.EntityReader;
import meugeninua.fetchgithubrepositories.model.json.writers.EntityWriter;
import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;
import okhttp3.OkHttpClient;

public interface AppComponent {

    Context provideAppContext();

    ViewModelProvider.Factory provideViewModelFactory();

    GithubService provideGithubService();

    OkHttpClient provideOkHttpClient();

    Executor provideExecutor();

    GithubRepository provideUseCaseFactory();

    EntityReader<AuthEntity> provideAuthEntityReader();

    EntityReader<ReposEntity> provideReposEntityReader();

    EntityReader<List<ReposEntity>> provideReposEntitiesReader();

    EntityWriter<CreateAuthBody> provideAuthBodyWriter();
}
