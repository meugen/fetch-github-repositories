package meugeninua.fetchgithubrepositories.ui.fragments.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.ui.di.ReposComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.base.BaseFragment;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.Binding;
import meugeninua.fetchgithubrepositories.ui.fragments.content.binding.ContentBinding;
import meugeninua.fetchgithubrepositories.ui.fragments.content.binding.ContentBindingImpl;

public class ContentFragment extends BaseFragment<ReposComponent, ContentBinding> {

    private ReposComponent.GithubReposProvider provider;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        provider.getGithubRepositories().observe(this,
                result -> binding.setupContent(result.data));
    }

    @Override
    public void inject(final ReposComponent appComponent) {
        provider = appComponent.provideGithubReposProvider();
        binding = new ContentBindingImpl(getContext());
    }
}
