package app.we.go.utils.rx2;

import io.reactivex.CompletableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;

/**
 * Interface of factory for creating {@link Transformer}, typically to wrap the
 * <code>subscribeOn</code> and <code>observeOn</code> operators.
 */
public interface TransformerFactory {

    <U> ObservableTransformer<U, U> getObservableTransformer();
    <U> SingleTransformer<U, U> getSingleTransformer();
    CompletableTransformer getCompletableTransformer();

}
