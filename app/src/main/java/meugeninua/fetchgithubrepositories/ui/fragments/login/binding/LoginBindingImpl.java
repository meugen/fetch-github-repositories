package meugeninua.fetchgithubrepositories.ui.fragments.login.binding;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.lang.ref.WeakReference;

import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.ui.di.LoginComponent;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.BaseBindingImpl;

public class LoginBindingImpl extends BaseBindingImpl
        implements LoginBinding {

    private final Resources resources;
    private WeakReference<LoginComponent.OnLoginClickListener> listenerRef;

    public LoginBindingImpl(final Resources resources) {
        this.resources = resources;
    }

    @Override
    public void setupLoginListener(final LoginComponent.OnLoginClickListener listener) {
        listenerRef = new WeakReference<>(listener);
        this.get(R.id.login_button).setOnClickListener(new OnClickListenerImpl(this));
    }

    private void callLoginClick() {
        LoginComponent.OnLoginClickListener listener = listenerRef.get();
        if (listener == null) {
            return;
        }
        EditText editUsernameView = get(R.id.edit_username);
        CharSequence username = editUsernameView.getText();
        if (TextUtils.isEmpty(username)) {
            editUsernameView.setError(resources.getText(R.string.login_error_required_field));
            return;
        }
        EditText editPasswordView = get(R.id.edit_password);
        CharSequence password = editPasswordView.getText();
        if (TextUtils.isEmpty(password)) {
            editPasswordView.setError(resources.getText(R.string.login_error_required_field));
            return;
        }
        listener.onLoginClick(username.toString(), password.toString());
    }

    private static class OnClickListenerImpl implements View.OnClickListener {

        private final WeakReference<LoginBindingImpl> bindingRef;

        OnClickListenerImpl(final LoginBindingImpl binding) {
            this.bindingRef = new WeakReference<>(binding);
        }

        @Override
        public void onClick(final View view) {
            LoginBindingImpl binding = bindingRef.get();
            if (binding == null) {
                return;
            }
            int viewId = view.getId();
            if (viewId == R.id.login_button) {
                binding.callLoginClick();
            }
        }
    }
}
