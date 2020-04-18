package ia.nazarov.gamesys.repositories;

import ia.nazarov.gamesys.enums.FetcherType;
import ia.nazarov.gamesys.models.ResourceToGrab;

import java.util.Set;

public interface GrabberResourceRepository {
    Set<ResourceToGrab> getResourcesToGrab(FetcherType fetcherType);
}
