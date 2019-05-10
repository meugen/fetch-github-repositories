package meugeninua.fetchgithubrepositories.ui.activities.base;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Executor;

import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.model.json.readers.EntityReader;
import meugeninua.fetchgithubrepositories.model.json.writers.EntityWriter;
import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;
import meugeninua.fetchgithubrepositories.ui.di.ActivityComponent;
import okhttp3.OkHttpClient;

public abstract class BaseComponentImpl<A extends AppCompatActivity>
        implements ActivityComponent {

    private final AppComponent appComponent;
    private final WeakReference<A> activityRef;

    protected BaseComponentImpl(
            final AppComponent appComponent,
            final A activity) {
        this.appComponent = appComponent;
        this.activityRef = new WeakReference<>(activity);
    }

    protected <VM extends ViewModel> VM getViewModel(final Class<VM> clazz) {
        return ViewModelProviders
                .of(provideActivityContext(), provideViewModelFactory())
                .get(clazz);
    }

    @Override
    public A provideActivityContext() {
        return activityRef.get();
    }

    @Override
    public Context provideAppContext() {
        return appComponent.provideAppContext();
    }

    @Override
    public ViewModelProvider.Factory provideViewModelFactory() {
        return appComponent.provideViewModelFactory();
    }

    @Override
    public GithubService provideGithubService() {
        return appComponent.provideGithubService();
    }

    @Override
    public OkHttpClient provideOkHttpClient() {
        return appComponent.provideOkHttpClient();
    }

    @Override
    public Executor provideExecutor() {
        return appComponent.provideExecutor();
    }

    @Override
    public GithubRepository provideUseCaseFactory() {
        return appComponent.provideUseCaseFactory();
    }

    @Override
    public EntityReader<AuthEntity> provideAuthEntityReader() {
        return appComponent.provideAuthEntityReader();
    }

    @Override
    public EntityReader<ReposEntity> provideReposEntityReader() {
        return appComponent.provideReposEntityReader();
    }

    @Override
    public EntityReader<List<ReposEntity>> provideReposEntitiesReader() {
        return appComponent.provideReposEntitiesReader();
    }

    @Override
    public EntityWriter<CreateAuthBody> provideAuthBodyWriter() {
        return appComponent.provideAuthBodyWriter();
    }
}
