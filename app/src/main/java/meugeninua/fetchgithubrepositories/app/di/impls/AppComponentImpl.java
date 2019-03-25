package meugeninua.fetchgithubrepositories.app.di.impls;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.ViewModelProvider;
import meugeninua.fetchgithubrepositories.BuildConfig;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.app.di.impls.conf.ConfigurationUtils;
import meugeninua.fetchgithubrepositories.app.di.impls.json.DateAdapter;
import meugeninua.fetchgithubrepositories.model.Repository;
import meugeninua.fetchgithubrepositories.model.factory.UseCaseFactory;
import meugeninua.fetchgithubrepositories.model.factory.impls.UseCaseFactoryImpl;
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
    private Repository repository;
    private ExecutorService executorService;
    private UseCaseFactory useCaseFactory;

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
    public Repository provideRepository() {
        if (repository == null) {
            repository = new Repository(provideGithubService());
        }
        return repository;
    }

    @Override
    public ExecutorService provideExecutorService() {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(2);
        }
        return executorService;
    }

    @Override
    public UseCaseFactory provideUseCaseFactory() {
        if (useCaseFactory == null) {
            useCaseFactory = new UseCaseFactoryImpl(provideGithubService());
        }
        return useCaseFactory;
    }
}
