package meugeninua.fetchgithubrepositories.ui.fragments.message.binding;

import android.widget.TextView;

import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.BaseBindingImpl;

public class MessageBindingImpl extends BaseBindingImpl
        implements MessageBinding {

    @Override
    public void displayMessage(final CharSequence message) {
        TextView messageView = get(R.id.message);
        messageView.setText(message);
    }
}
