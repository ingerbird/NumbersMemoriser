package ia.nazarov.test.gamesys.mappers;

/**
 * Basic mapper interface
 * @param <F> Input value to map
 * @param <T> Result of mapping
 */
interface BasicMapper<F, T> {
    T map(F input);
}
