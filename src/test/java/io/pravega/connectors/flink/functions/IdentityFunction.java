/**
 * Copyright (c) 2017 Dell Inc., or its subsidiaries. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package io.pravega.connectors.flink.functions;

import org.apache.flink.api.common.functions.RichMapFunction;

/**
 * A simple identity function.
 * @param <T> the type of elements to process.
 */
public class IdentityFunction<T> extends RichMapFunction<T, T> {
    @Override
    public T map(T element) throws Exception {
        return element;
    }
}
