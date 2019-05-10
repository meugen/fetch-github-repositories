package meugeninua.fetchgithubrepositories.app.di.impls;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.ViewModelProvider;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.app.di.impls.conf.ConfigurationUtils;
import meugeninua.fetchgithubrepositories.model.json.readers.impls.AuthEntityReader;
import meugeninua.fetchgithubrepositories.model.json.readers.impls.EntitiesListReader;
import meugeninua.fetchgithubrepositories.model.json.readers.impls.ReposEntityReader;
import meugeninua.fetchgithubrepositories.model.json.writers.impls.AuthBodyWriter;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import meugeninua.fetchgithubrepositories.model.network.services.impls.GithubServiceImpl;
import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;
import meugeninua.fetchgithubrepositories.model.repositories.impls.GithubRepositoryImpl;
import okhttp3.OkHttpClient;

public class AppComponentImpl implements AppComponent {

    private final WeakReference<Application> appRef;
    private ViewModelProvider.Factory viewModelFactory;
    private GithubService githubService;
    private OkHttpClient httpClient;
    private GithubRepository githubRepository;

    private AuthEntityReader authEntityReader;
    private ReposEntityReader reposEntityReader;
    private AuthBodyWriter authBodyWriter;
    private EntitiesListReader<ReposEntity> reposEntitiesReader;

    public AppComponentImpl(final Application app) {
        this.appRef = new WeakReference<>(app);
    }

    @Override
    public Application provideAppContext() {
        return appRef.get();
    }

    @Override
    public ViewModelProvider.Factory provideViewModelFactory() {
        if (viewModelFactory == null) {
            viewModelFactory = new ViewModelFactoryImpl(this);
        }
        return viewModelFactory;
    }

    @Override
    public OkHttpClient provideOkHttpClient() {
        if (httpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            ConfigurationUtils.configureOkHttpBuilder(builder);
            httpClient = builder.build();
        }
        return httpClient;
    }

    @Override
    public GithubService provideGithubService() {
        if (githubService == null) {
            githubService = new GithubServiceImpl(
                    provideOkHttpClient(),
                    provideAuthBodyWriter());
        }
        return githubService;
    }

    @Override
    public AuthEntityReader provideAuthEntityReader() {
        if (authEntityReader == null) {
            authEntityReader = new AuthEntityReader();
        }
        return authEntityReader;
    }

    @Override
    public ReposEntityReader provideReposEntityReader() {
        if (reposEntityReader == null) {
            reposEntityReader = new ReposEntityReader();
        }
        return reposEntityReader;
    }

    @Override
    public EntitiesListReader<ReposEntity> provideReposEntitiesReader() {
        if (reposEntitiesReader == null) {
            reposEntitiesReader = new EntitiesListReader<>(provideReposEntityReader());
        }
        return reposEntitiesReader;
    }

    @Override
    public AuthBodyWriter provideAuthBodyWriter() {
        if (authBodyWriter == null) {
            authBodyWriter = new AuthBodyWriter();
        }
        return authBodyWriter;
    }

    @Override
    public Executor provideExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    @Override
    public GithubRepository provideUseCaseFactory() {
        if (githubRepository == null) {
            githubRepository = new GithubRepositoryImpl(
                    provideGithubService(),
                    provideAuthEntityReader(),
                    provideReposEntitiesReader());
        }
        return githubRepository;
    }
}
