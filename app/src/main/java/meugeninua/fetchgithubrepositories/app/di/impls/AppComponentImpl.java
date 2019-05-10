package meugeninua.fetchgithubrepositories.app.di.impls;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.Executor;

import meugeninua.fetchgithubrepositories.BuildConfig;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.app.di.impls.conf.ConfigurationUtils;
import meugeninua.fetchgithubrepositories.app.di.impls.json.DateAdapter;
import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;
import meugeninua.fetchgithubrepositories.model.repositories.impls.GithubRepositoryImpl;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppComponentImpl implements AppComponent {

    private final WeakReference<Application> appRef;
    private ViewModelProvider.Factory viewModelFactory;
    private Gson gson;
    private GithubService githubService;
    private OkHttpClient httpClient;
    private GithubRepository githubRepository;

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
    public Gson provideGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateAdapter())
                    .create();
        }
        return gson;
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
            githubService = new Retrofit.Builder()
                    .baseUrl(BuildConfig.GITHUB_API_URL)
                    .client(provideOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(provideGson()))
                    .build().create(GithubService.class);
        }
        return githubService;
    }

    @Override
    public Executor provideExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    @Override
    public GithubRepository provideUseCaseFactory() {
        if (githubRepository == null) {
            githubRepository = new GithubRepositoryImpl(provideGithubService());
        }
        return githubRepository;
    }
}
