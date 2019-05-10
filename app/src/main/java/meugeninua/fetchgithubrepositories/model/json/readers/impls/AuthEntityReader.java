package meugeninua.fetchgithubrepositories.model.json.readers.impls;

import android.util.JsonReader;

import java.io.IOException;

import meugeninua.fetchgithubrepositories.model.network.entities.AuthEntity;

public class AuthEntityReader extends AbstractReader<AuthEntity> {

    @Override
    protected AuthEntity read(final JsonReader reader) throws IOException {
        AuthEntity entity = new AuthEntity();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if ("id".equals(name)) {
                entity.id = reader.nextInt();
            } else if ("url".equals(name)) {
                entity.url = nextStringOrNull(reader);
            } else if ("scopes".equals(name)) {
                entity.scopes = nextStrings(reader);
            } else if ("token".equals(name)) {
                entity.token = nextStringOrNull(reader);
            } else if ("hashed_token".equals(name)) {
                entity.hashedToken = nextStringOrNull(reader);
            } else if ("note".equals(name)) {
                entity.note = nextStringOrNull(reader);
            } else if ("note_url".equals(name)) {
                entity.noteUrl = nextStringOrNull(reader);
            } else if ("updated_at".equals(name)) {
                entity.updatedAt = nextDate(reader);
            } else if ("created_at".equals(name)) {
                entity.createdAt = nextDate(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return entity;
    }
}
