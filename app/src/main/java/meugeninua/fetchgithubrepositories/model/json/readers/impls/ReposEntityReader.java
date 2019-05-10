package meugeninua.fetchgithubrepositories.model.json.readers.impls;

import android.util.JsonReader;

import java.io.IOException;

import meugeninua.fetchgithubrepositories.model.network.entities.ReposEntity;

public class ReposEntityReader extends AbstractReader<ReposEntity> {

    @Override
    protected ReposEntity read(final JsonReader reader) throws IOException {
        ReposEntity entity = new ReposEntity();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if ("id".equals(name)) {
                entity.id = reader.nextInt();
            } else if ("node_id".equals(name)) {
                entity.nodeId = nextStringOrNull(reader);
            } else if ("name".equals(name)) {
                entity.name = nextStringOrNull(reader);
            } else if ("full_name".equals(name)) {
                entity.fullName = nextStringOrNull(reader);
            } else if ("private".equals(name)) {
                entity.isPrivate = reader.nextBoolean();
            } else if ("html_url".equals(name)) {
                entity.htmlUrl = nextStringOrNull(reader);
            } else if ("description".equals(name)) {
                entity.description = nextStringOrNull(reader);
            } else if ("fork".equals(name)) {
                entity.fork = reader.nextBoolean();
            } else if ("url".equals(name)) {
                entity.url = nextStringOrNull(reader);
            } else if ("fork_url".equals(name)) {
                entity.forkUrl = nextStringOrNull(reader);
            } else if ("keys_url".equals(name)) {
                entity.keysUrl = nextStringOrNull(reader);
            } else if ("collaborators_url".equals(name)) {
                entity.collaboratorUrl = nextStringOrNull(reader);
            } else if ("teams_url".equals(name)) {
                entity.teamsUrl = nextStringOrNull(reader);
            } else if ("hooks_url".equals(name)) {
                entity.hooksUrl = nextStringOrNull(reader);
            } else if ("issue_events_url".equals(name)) {
                entity.issueEventsUrl = nextStringOrNull(reader);
            } else if ("events_url".equals(name)) {
                entity.eventsUrl = nextStringOrNull(reader);
            } else if ("assignees_url".equals(name)) {
                entity.assigneesUrl = nextStringOrNull(reader);
            } else if ("branches_url".equals(name)) {
                entity.branchesUrl = nextStringOrNull(reader);
            } else if ("tags_url".equals(name)) {
                entity.tagsUrl = nextStringOrNull(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return entity;
    }
}
