package meugeninua.fetchgithubrepositories.model.json.writers.impls;

import android.util.JsonWriter;

import java.io.IOException;

import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;

public class AuthBodyWriter extends AbstractWriter<CreateAuthBody> {

    @Override
    protected void write(final JsonWriter writer, final CreateAuthBody entity) throws IOException {
        writer.beginObject();
        value(writer.name("scopes"), entity.scopes);
        writer.name("note").value(entity.note);
        writer.name("note_url").value(entity.noteUrl);
        writer.name("client_id").value(entity.clientId);
        writer.name("client_secret").value(entity.clientSecret);
        writer.name("fingerpring").value(entity.fingerprint);
        writer.endObject();
    }
}
