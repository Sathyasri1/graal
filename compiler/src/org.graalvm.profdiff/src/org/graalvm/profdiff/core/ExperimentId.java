/*
 * Copyright (c) 2022, 2023, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.profdiff.core;

/**
 * Identifies an experiment in the context of one or more experiments loaded by the program.
 *
 * The first experiment is assigned the ID {@link #ONE} and the second (if any) is assigned the ID
 * {@link #TWO}. An additional experiment used to identify hot methods gets the ID
 * {@link #AUXILIARY}.
 */
public enum ExperimentId {
    /**
     * The ID of the first experiment.
     */
    ONE,
    /**
     * The ID of the second experiment.
     */
    TWO,
    /**
     * The ID of an auxiliary experiment, which is used to identify hot methods.
     */
    AUXILIARY;

    @Override
    public String toString() {
        switch (this) {
            case AUXILIARY:
                return "0";
            case ONE:
                return "1";
            case TWO:
                return "2";
        }
        throw new RuntimeException();
    }
}
