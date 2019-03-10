package meugeninua.fetchgithubrepositories.ui.fragments.login.binding;

import meugeninua.fetchgithubrepositories.ui.di.LoginComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.Binding;

public interface LoginBinding extends Binding {

    void setupLoginListener(LoginComponent.OnLoginClickListener listener);
}
