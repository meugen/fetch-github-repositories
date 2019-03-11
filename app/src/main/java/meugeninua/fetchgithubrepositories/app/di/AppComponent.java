package meugeninua.fetchgithubrepositories.app.di;

import android.content.Context;

import com.google.gson.Gson;

import androidx.lifecycle.ViewModelProvider;
import meugeninua.fetchgithubrepositories.model.services.GithubService;
import okhttp3.OkHttpClient;

public interface AppComponent {

    Context provideAppContext();

    ViewModelProvider.Factory provideViewModelFactory();

    Gson provideGson();

    GithubService provideGithubService();

    OkHttpClient provideOkHttpClient();
}
