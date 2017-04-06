package app.we.go.utils.rx2;

import io.reactivex.CompletableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;

/**
 * Interface for a factory that can create {@link Transformer} that can compose appropriate schedulers to an
 * {@link io.reactivex.Observable}/{@link io.reactivex.Single}/{@link io.reactivex.Completable}.
 */
public interface SchedulersTransformerFactory {

    <U> ObservableTransformer<U, U> forObservable();
    <U> SingleTransformer<U, U> forSingle();
    CompletableTransformer forCompletable();

}
