package meugeninua.fetchgithubrepositories.model.json.readers;

import java.io.IOException;
import java.io.Reader;

public interface EntityReader<T> {

    T read(Reader reader) throws IOException;
}
