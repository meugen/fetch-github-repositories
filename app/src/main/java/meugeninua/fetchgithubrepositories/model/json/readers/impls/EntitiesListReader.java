package meugeninua.fetchgithubrepositories.model.json.readers.impls;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntitiesListReader<T> extends AbstractReader<List<T>> {

    private final AbstractReader<T> entityReader;

    public EntitiesListReader(final AbstractReader<T> entityReader) {
        this.entityReader = entityReader;
    }

    @Override
    protected List<T> read(final JsonReader reader) throws IOException {
        List<T> result = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            result.add(entityReader.read(reader));
        }
        reader.endArray();
        return result;
    }
}
