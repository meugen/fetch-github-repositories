package meugeninua.fetchgithubrepositories.ui.fragments.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.ui.di.LoginComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.base.BaseFragment;
import meugeninua.fetchgithubrepositories.ui.fragments.login.binding.LoginBinding;
import meugeninua.fetchgithubrepositories.ui.fragments.login.binding.LoginBindingImpl;

public class LoginFragment extends BaseFragment<LoginComponent, LoginBinding> {

    private LoginComponent.OnLoginClickListener listener;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setupLoginListener(listener);
    }

    @Override
    public void inject(final LoginComponent component) {
        binding = new LoginBindingImpl(getResources());
        listener = component.provideLoginClickListener();
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }
}
