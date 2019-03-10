package meugeninua.fetchgithubrepositories.ui.di;

public interface MainComponent extends LoginComponent, ReposComponent {

    GithubReposLoader provideGithubReposLoader();

    interface GithubReposLoader {

        void loadGithubRepositories(String username, String password);
    }
}
