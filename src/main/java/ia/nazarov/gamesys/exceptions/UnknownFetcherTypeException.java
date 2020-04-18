package ia.nazarov.gamesys.exceptions;

import ia.nazarov.gamesys.enums.FetcherType;
import lombok.Getter;

/**
 * Checked exception representing the fact that requested fetcherType does not implemented yet
 */
@Getter
public class UnknownFetcherTypeException extends Exception {
    private FetcherType fetcherType;
    public UnknownFetcherTypeException(FetcherType fetcherType) {
        super(String.format("Fetcher type [%s] does not implemented yet", fetcherType.toString()));
        this.fetcherType = fetcherType;
    }
}
