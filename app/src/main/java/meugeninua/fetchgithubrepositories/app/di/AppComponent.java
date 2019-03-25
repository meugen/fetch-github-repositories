package meugeninua.fetchgithubrepositories.app.di;

import android.content.Context;

import com.google.gson.Gson;

import java.util.concurrent.ExecutorService;

import androidx.lifecycle.ViewModelProvider;
import meugeninua.fetchgithubrepositories.model.Repository;
import meugeninua.fetchgithubrepositories.model.factory.UseCaseFactory;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import okhttp3.OkHttpClient;

public interface AppComponent {

    Context provideAppContext();

    ViewModelProvider.Factory provideViewModelFactory();

    Gson provideGson();

    GithubService provideGithubService();

    OkHttpClient provideOkHttpClient();

    Repository provideRepository();

    ExecutorService provideExecutorService();

    UseCaseFactory provideUseCaseFactory();
}
