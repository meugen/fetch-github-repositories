package meugeninua.fetchgithubrepositories.ui.di;

import android.content.Context;

import meugeninua.fetchgithubrepositories.app.di.AppComponent;

public interface ActivityComponent extends AppComponent {

    Context provideActivityContext();

    interface Container<C extends ActivityComponent> {

        C provideActivityComponent();
    }
}
