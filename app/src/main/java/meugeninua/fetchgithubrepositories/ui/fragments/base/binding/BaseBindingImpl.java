package meugeninua.fetchgithubrepositories.ui.fragments.base.binding;

import android.util.SparseArray;
import android.view.View;

import java.lang.ref.WeakReference;

import androidx.annotation.Nullable;

public class BaseBindingImpl implements Binding {

    private WeakReference<View> rootViewRef;
    private SparseArray<WeakReference<View>> childrenViewRefs;

    @Override
    public void attachView(final View view) {
        rootViewRef = new WeakReference<>(view);
        childrenViewRefs = new SparseArray<>();
    }

    @Override
    public void detachView() {
        rootViewRef = null;
        childrenViewRefs = null;
    }

    @Nullable
    public <V extends View> V getNullable(final int id) {
        if (rootViewRef == null || childrenViewRefs == null) {
            return null;
        }
        WeakReference<View> childViewRef = childrenViewRefs.get(id);
        View childView = childViewRef == null ? null : childViewRef.get();
        if (childView != null) {
            return (V) childView;
        }
        View rootView = rootViewRef.get();
        if (rootView == null) {
            return null;
        }
        childView = rootView.findViewById(id);
        childrenViewRefs.put(id, new WeakReference<View>(childView));
        return (V) childView;
    }

    @Override
    public <V extends View> V get(final int id) {
        V view = getNullable(id);
        if (view == null) {
            throw new IllegalArgumentException("View with id " + id + " is not found");
        }
        return view;
    }

    @Override
    public boolean has(final int id) {
        return getNullable(id) != null;
    }
}
