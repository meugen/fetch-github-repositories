package meugeninua.fetchgithubrepositories.ui.di;

public interface LoginComponent extends ActivityComponent {

    OnLoginClickListener provideLoginClickListener();

    interface OnLoginClickListener {

        void onLoginClick(String username, String password);
    }
}
