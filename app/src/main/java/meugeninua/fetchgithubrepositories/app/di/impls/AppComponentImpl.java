package meugeninua.fetchgithubrepositories.app.di.impls;

import android.app.Application;

import java.lang.ref.WeakReference;

import androidx.lifecycle.ViewModelProvider;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;

public class AppComponentImpl implements AppComponent {

    private final WeakReference<Application> appRef;
    private ViewModelProvider.Factory viewModelFactory;

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
}
