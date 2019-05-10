package meugeninua.fetchgithubrepositories.ui.activities.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import meugeninua.fetchgithubrepositories.app.GithubApp;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.ui.di.ActivityComponent;

public abstract class BaseActivity<C extends ActivityComponent> extends AppCompatActivity
        implements ActivityComponent.Container<C> {

    private C component;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        component = createActivityComponent(GithubApp.provideAppComponent(this));
        super.onCreate(savedInstanceState);
    }

    @Override
    public C provideActivityComponent() {
        return component;
    }

    protected abstract C createActivityComponent(final AppComponent appComponent);
}
