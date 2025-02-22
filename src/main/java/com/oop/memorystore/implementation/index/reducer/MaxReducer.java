package com.oop.memorystore.implementation.index.reducer;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Reduces all elements for a key retaining the max value
 *
 * @param <K> key type
 * @param <V> value type
 */
public class MaxReducer<K, V> extends ComparingReducer<K, V> {
    public <C extends Comparable<? super C>> MaxReducer(
        final Function<V, C> valueProvider, final boolean nullGreater) {
        super(valueProvider, nullGreater);
    }

    public <C> MaxReducer(
        final Function<V, C> valueProvider,
        final Comparator<C> comparator,
        final boolean nullGreater) {
        super(valueProvider, comparator, nullGreater);
    }

    @Override
    int compare(
        final Object value1,
        final Object value2,
        final Comparator<Object> comparator,
        final boolean nullGreater) {
        if (value1 == value2) {
            return 0;
        }

        if (value1 == null) {
            return nullGreater ? 1 : -1;
        }

        if (value2 == null) {
            return nullGreater ? -1 : 1;
        }

        return comparator.compare(value1, value2);
    }
}
