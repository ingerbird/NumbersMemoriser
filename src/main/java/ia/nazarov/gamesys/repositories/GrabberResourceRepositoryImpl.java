package ia.nazarov.gamesys.repositories;

import ia.nazarov.gamesys.enums.FetcherType;
import ia.nazarov.gamesys.models.ResourceToGrab;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Set;

@Repository
public class GrabberResourceRepositoryImpl implements GrabberResourceRepository {
    @Override
    public Set<ResourceToGrab> getResourcesToGrab(FetcherType fetcherType) {
        // TODO: Need to refactor. Just for sake of simplicity
        return Collections.singleton(new ResourceToGrab("https://bash.im/rss/", FetcherType.RSS));
    }
}
