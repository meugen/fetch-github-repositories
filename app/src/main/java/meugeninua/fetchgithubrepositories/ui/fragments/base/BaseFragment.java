package meugeninua.fetchgithubrepositories.ui.fragments.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import meugeninua.fetchgithubrepositories.app.di.Injectable;
import meugeninua.fetchgithubrepositories.ui.di.ActivityComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.Binding;

public abstract class BaseFragment<C extends ActivityComponent, B extends Binding> extends Fragment
        implements Injectable<C> {

    protected B binding;

    @Override
    public void onAttach(final Context context) {
        ActivityComponent.Container<C> container = (ActivityComponent.Container<C>) context;
        inject(container.provideActivityComponent());
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(
            @NonNull final View view,
            @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.attachView(view);
    }

    @Override
    public void onDestroyView() {
        binding.detachView();
        super.onDestroyView();
    }

    protected <VM extends ViewModel> VM getViewModel(
            final ViewModelProvider.Factory factory,
            final Class<VM> clazz) {
        return ViewModelProviders.of(this, factory).get(clazz);
    }
}
