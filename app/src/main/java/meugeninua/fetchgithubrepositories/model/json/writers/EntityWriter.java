package meugeninua.fetchgithubrepositories.model.json.writers;

import java.io.IOException;
import java.io.Writer;

public interface EntityWriter<T> {

    void write(Writer writer, T entity) throws IOException;
}
