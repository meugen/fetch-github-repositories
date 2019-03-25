package meugeninua.fetchgithubrepositories.ui.fragments.base.binding;

import android.view.View;

public interface Binding {

    Binding EMPTY = new BaseBindingImpl() {};

    void attachView(View view);

    void detachView();

    <V extends View> V get(int id);

    boolean has(int id);
}
