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

import io.pravega.connectors.flink.utils.IntentionalException;
import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;

/**
 * An identity map function that fails at checkpoint time (on the first attempt).
 */
public class FailAtCheckpointFunction<T> extends IdentityFunction<T> implements CheckpointedFunction {

    @Override
    public void initializeState(FunctionInitializationContext context) throws Exception {
    }

    @Override
    public void snapshotState(FunctionSnapshotContext context) throws Exception {
        if (getRuntimeContext().getAttemptNumber() == 0) {
            throw new IntentionalException("intentional failure in snapshotState");
        }
    }
}