package meugeninua.fetchgithubrepositories.ui.fragments.content.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import meugeninua.fetchgithubrepositories.R;
import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposHolder> {

    private final LayoutInflater inflater;
    private final List<ReposEntity> content;

    public ReposAdapter(final Context context, final List<ReposEntity> content) {
        this.inflater = LayoutInflater.from(context);
        this.content = content;
    }

    @NonNull
    @Override
    public ReposHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View view = inflater.inflate(R.layout.item_repos, parent, false);
        return new ReposHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReposHolder holder, final int position) {
        holder.bind(content.get(position));
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    static class ReposHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        ReposHolder(@NonNull final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }

        void bind(final ReposEntity entity) {
            textView.setText(entity.name);
        }
    }
}
