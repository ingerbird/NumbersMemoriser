package ia.nazarov.gamesys.utils;

import ia.nazarov.gamesys.enums.FetcherType;
import ia.nazarov.gamesys.exceptions.UnknownFetcherTypeException;
import ia.nazarov.gamesys.readers.ArticleFetcher;
import ia.nazarov.gamesys.readers.RssFetcher;

public class ArticleFetcherFactory {
    public static ArticleFetcher getFetcherFor(FetcherType fetcherType) throws UnknownFetcherTypeException {
        if (fetcherType == FetcherType.RSS) {
            return new RssFetcher();
        }
        else throw new UnknownFetcherTypeException(fetcherType);
    }
}
