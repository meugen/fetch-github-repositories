package meugeninua.fetchgithubrepositories.app;

import android.app.Application;
import android.content.Context;

import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.app.di.impls.AppComponentImpl;

public class GithubApp extends Application {

    public static AppComponent provideAppComponent(final Context context) {
        GithubApp app = (GithubApp) context.getApplicationContext();
        if (app.appComponent == null) {
            app.appComponent = new AppComponentImpl(app);
        }
        return app.appComponent;
    }

    private AppComponent appComponent;
}
