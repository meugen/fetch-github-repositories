package meugeninua.fetchgithubrepositories.app.di;

public interface Injectable<C extends AppComponent> {

    void inject(C appComponent);
}
