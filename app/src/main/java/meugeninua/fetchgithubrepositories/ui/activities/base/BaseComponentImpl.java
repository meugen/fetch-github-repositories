package meugeninua.fetchgithubrepositories.ui.activities.base;

import android.content.Context;

import java.lang.ref.WeakReference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.ui.di.ActivityComponent;

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
    public FragmentManager provideFragmentManager() {
        return provideActivityContext().getSupportFragmentManager();
    }

    @Override
    public Context provideAppContext() {
        return appComponent.provideAppContext();
    }

    @Override
    public ViewModelProvider.Factory provideViewModelFactory() {
        return appComponent.provideViewModelFactory();
    }
}
