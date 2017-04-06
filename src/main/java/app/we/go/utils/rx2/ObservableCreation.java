package app.we.go.utils.rx2;

import io.reactivex.Observable;

import java.io.BufferedReader;

public class ObservableCreation {

    public ObservableCreation() {
        // Private constructor for static utils class
    }


    /**
     * Creates an {@link Observable} that emits all lines of a {@link BufferedReader} as {@link String}s.
     *
     * @param reader The {@link BufferedReader} to read from
     * @return An {@link Observable} that emits {@link String}s.
     */
    public static Observable<String> fromBufferedReader(BufferedReader reader) {
        return Observable.create(e -> {
            String line;
            // Notice that we need to check whether the emitter has been closed
            // before reading the next line, because the reader might have been auto-closed
            // onDispose
            while (!e.isDisposed() && (line = reader.readLine()) != null) {
                e.onNext(line);
            }
            e.onComplete();
        });
    }

    /**
     * Creates an {@link Observable} that emits all lines of a {@link BufferedReader} as {@link String}s
     * and closes the reader on termination.
     *
     * @param reader The {@link BufferedReader} to read from
     * @return An {@link Observable} that emits {@link String}s.
     * <p>
     * TODO make this an operator (<code>autoClose</code>) that can be applied to {@link #fromBufferedReader(BufferedReader)}
     */
    public static Observable<String> fromBufferedReaderAutoClose(BufferedReader reader) {

        return Observable.using(
                () -> reader,
                ObservableCreation::fromBufferedReader,
                BufferedReader::close
        );
    }
}
