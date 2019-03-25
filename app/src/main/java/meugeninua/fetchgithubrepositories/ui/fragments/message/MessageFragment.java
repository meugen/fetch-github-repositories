package meugeninua.fetchgithubrepositories.ui.fragments.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.app.di.AppComponent;
import meugeninua.fetchgithubrepositories.ui.di.ActivityComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.base.BaseFragment;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.Binding;
import meugeninua.fetchgithubrepositories.ui.fragments.message.binding.MessageBinding;
import meugeninua.fetchgithubrepositories.ui.fragments.message.binding.MessageBindingImpl;

public class MessageFragment extends BaseFragment<ActivityComponent, MessageBinding> {

    private static final String ARG_MESSAGE = "message";

    public static MessageFragment newInstance(final CharSequence message) {
        Bundle args = new Bundle();
        args.putCharSequence(ARG_MESSAGE, message);

        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.displayMessage(getArguments().getCharSequence(ARG_MESSAGE));
    }

    @Override
    public void inject(final ActivityComponent appComponent) {
        binding = new MessageBindingImpl();
    }
}
