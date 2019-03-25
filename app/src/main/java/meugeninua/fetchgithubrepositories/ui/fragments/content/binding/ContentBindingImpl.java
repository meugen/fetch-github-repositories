package meugeninua.fetchgithubrepositories.ui.fragments.content.binding;

import android.content.Context;

import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.BaseBindingImpl;
import meugeninua.fetchgithubrepositories.ui.fragments.content.adapters.ReposAdapter;

public class ContentBindingImpl extends BaseBindingImpl implements ContentBinding {

    private final Context context;

    public ContentBindingImpl(final Context context) {
        this.context = context;
    }

    @Override
    public void setupContent(final List<ReposEntity> content) {
        RecyclerView recyclerView = get(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new ReposAdapter(context, content));
    }
}
