package ia.nazarov.gamesys.models;

import ia.nazarov.gamesys.enums.FetcherType;
import lombok.Data;

@Data
public class ResourceToGrab {
    private final String uri;
    private final FetcherType fetcherType;
}
