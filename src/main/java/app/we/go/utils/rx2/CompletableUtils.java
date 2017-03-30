package app.we.go.utils.rx2;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;

public class CompletableUtils {

    private CompletableUtils() {
        // Private constructor for static utils class
    }


    /**
     * Receives a {@link Completable} and returns a {@link Single<Boolean>} that emits <code>true</code>
     * if the <code>Completable</code> completes successful, <code>false</code> otherwise.
     * An action to performed in case or error can also be passed through the argument
     * <code>exceptionConsumer</code>
     *
     * @param completable       The input {@link Completable}
     * @param exceptionConsumer A consumer to execute in case the {@link Completable} terminates with an error.
     * @return The {@link Single<Boolean>}, as described above.
     */
    public static Single<Boolean> toSingle(Completable completable, @Nullable Consumer<? super Throwable> exceptionConsumer) {
        return completable
                .doOnError(exceptionConsumer == null ? throwable -> {} : exceptionConsumer)
                .toSingleDefault(true)
                .onErrorReturnItem(false);
    }
}
