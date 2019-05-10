package meugeninua.fetchgithubrepositories.app.di;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import java.util.concurrent.Executor;

import meugeninua.fetchgithubrepositories.model.repositories.GithubRepository;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import okhttp3.OkHttpClient;

public interface AppComponent {

    Context provideAppContext();

    ViewModelProvider.Factory provideViewModelFactory();

    Gson provideGson();

    GithubService provideGithubService();

    OkHttpClient provideOkHttpClient();

    Executor provideExecutor();

    GithubRepository provideUseCaseFactory();
}
