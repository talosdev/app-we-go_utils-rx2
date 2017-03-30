package app.we.go.utils.rx2;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;

public class CompletableUtils {

    private CompletableUtils() {
        // Private constractor for static utils class
    }


    public Single<Boolean> toSingle(Completable completable, @Nullable Consumer<? super Throwable> consumer) {
        return completable
                .doOnError(consumer == null ? throwable -> {} : consumer)
                .toSingleDefault(true)
                .onErrorReturnItem(false);
    }
}
