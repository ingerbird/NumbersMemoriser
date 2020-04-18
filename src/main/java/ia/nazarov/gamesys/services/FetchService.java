package ia.nazarov.gamesys.services;

import ia.nazarov.gamesys.models.Article;
import ia.nazarov.gamesys.models.ResourceToGrab;

import java.util.Set;

public interface FetchService {
    Set<Article> fetchNew(ResourceToGrab resourceToGrab);
}
