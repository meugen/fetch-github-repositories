package meugeninua.fetchgithubrepositories.app.di.impls;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.ref.WeakReference;

import androidx.lifecycle.ViewModelProvider;
import meugeninua.fetchgithubrepositories.BuildConfig;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.app.di.impls.conf.ConfigurationUtils;
import meugeninua.fetchgithubrepositories.model.http.services.GithubService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppComponentImpl implements AppComponent {

    private final WeakReference<Application> appRef;
    private ViewModelProvider.Factory viewModelFactory;
    private Gson gson;
    private GithubService githubService;
    private OkHttpClient httpClient;

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
            gson = new GsonBuilder().create();
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
}
