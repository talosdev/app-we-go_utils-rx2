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
            while ((line = reader.readLine()) != null) {
                if (!e.isDisposed()) {
                    e.onNext(line);
                }
            }
            e.onComplete();
        });
    }
}
