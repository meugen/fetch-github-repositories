package meugeninua.fetchgithubrepositories.ui.fragments.content.binding;

import java.util.List;

import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;
import meugeninua.fetchgithubrepositories.ui.fragments.base.binding.Binding;

public interface ContentBinding extends Binding {

    void setupContent(List<ReposEntity> content);
}
