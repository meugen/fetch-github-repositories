package meugeninua.fetchgithubrepositories.ui.fragments.progress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.ui.di.ActivityComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.base.BaseFragment;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.Binding;

public class ProgressFragment extends BaseFragment<ActivityComponent, Binding> {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress,
                container, false);
    }

    @Override
    public void inject(final ActivityComponent component) {
        binding = Binding.EMPTY;
    }
}
