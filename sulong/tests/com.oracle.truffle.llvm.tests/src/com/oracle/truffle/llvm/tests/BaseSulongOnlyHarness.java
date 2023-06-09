/*
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.truffle.llvm.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.oracle.truffle.llvm.tests.pipe.CaptureNativeOutput;
import com.oracle.truffle.llvm.tests.util.ProcessUtil;
import com.oracle.truffle.llvm.tests.util.ProcessUtil.ProcessResult;

public abstract class BaseSulongOnlyHarness {

    @Test
    public void test() throws IOException {
        ProcessResult out = ProcessUtil.executeSulongTestMain(getPath().toAbsolutePath().toFile(), getConfiguration().args, getContextOptions(), c -> new CaptureNativeOutput());
        int sulongResult = out.getReturnValue();
        String sulongStdOut = out.getStdOutput();

        if (!Platform.isWindows() && sulongResult != (sulongResult & 0xFF)) {
            Assert.fail("Broken unittest " + getPath() + ". Test exits with invalid value (" + sulongResult + ").");
        }
        String testName = getPath().getFileName().toString();
        Assert.assertEquals(testName + " failed. Posix return value missmatch.", getConfiguration().expectedPosixReturn,
                        sulongResult);
        if (getConfiguration().expectedOutput != null) {
            Assert.assertEquals(testName + " failed. Output (stdout) missmatch.", getConfiguration().expectedOutput,
                            sulongStdOut);
        }
    }

    public abstract Path getPath();

    public abstract RunConfiguration getConfiguration();

    protected Map<String, String> getContextOptions() {
        return Collections.emptyMap();
    }

    static final class RunConfiguration {
        private final int expectedPosixReturn;
        private final String expectedOutput;
        private final String[] args;

        RunConfiguration(int expectedPosixReturn, String expectedOutput) {
            this(expectedPosixReturn, expectedOutput, new String[]{});
        }

        RunConfiguration(int expectedPosixReturn, String expectedOutput, String[] args) {
            this.expectedPosixReturn = expectedPosixReturn;
            this.expectedOutput = expectedOutput;
            this.args = args;
        }

        String[] getArgs() {
            return args;
        }
    }
}
