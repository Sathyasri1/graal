/*
 * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.svm.core.jfr;

/**
 * An interface that collects all {@link JfrChunkWriter} methods that may be called without holding
 * a lock.
 */
public interface JfrUnlockedChunkWriter {
    /**
     * Initializes the chunk writer with the maximum size of a chunk.
     */
    void initialize(long maxChunkSize);

    /**
     * Locks the chunk writer returning a {@link JfrChunkWriter} which provides access to chunk
     * writing methods that require mutual exclusion.
     */
    JfrChunkWriter lock();

    /**
     * Returns true if the current thread holds the lock.
     */
    boolean isLockedByCurrentThread();

    /**
     * It is valid to call this method without locking but be aware that the result will be racy in
     * that case.
     */
    boolean hasOpenFile();
}
