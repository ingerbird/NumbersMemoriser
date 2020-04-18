package ia.nazarov.gamesys.services;

import ia.nazarov.gamesys.exceptions.UnknownFetcherTypeException;
import ia.nazarov.gamesys.filters.DuplicateFilter;
import ia.nazarov.gamesys.models.Article;
import ia.nazarov.gamesys.models.ResourceToGrab;
import ia.nazarov.gamesys.readers.ArticleFetcher;
import ia.nazarov.gamesys.utils.ArticleFetcherFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class FetchServiceImpl implements FetchService {
    private final DuplicateFilter duplicateFilter;

    @Autowired
    public FetchServiceImpl(DuplicateFilter duplicateFilter) {
        this.duplicateFilter = duplicateFilter;
    }

    /**
     * Returns new articles that has not been stored in system yet.
     * @param resource represents resource to grab
     * @return set of new (not processed yet) articles
     */
    @Override
    public Set<Article> fetchNew(ResourceToGrab resource) {
        ArticleFetcher fetcher;
        Set<Article> result = Collections.emptySet();
        try {
            fetcher = ArticleFetcherFactory.getFetcherFor(resource.getFetcherType());
        } catch (UnknownFetcherTypeException ex) {
            log.warn(String.format("Exception during getting fetcher for resource [%s]: %s", resource,
                    ex.getMessage()));
            return result;
        }
        List<Article> articles = fetcher.fetch(resource.getUri());
        result = duplicateFilter.filter(articles);
        return result;
    }
}
