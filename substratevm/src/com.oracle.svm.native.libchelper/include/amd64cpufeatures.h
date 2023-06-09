/*
 * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Oracle designates this
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

typedef struct {
  char fCX8;
  char fCMOV;
  char fFXSR;
  char fHT;
  char fMMX;
  char fAMD_3DNOW_PREFETCH;
  char fSSE;
  char fSSE2;
  char fSSE3;
  char fSSSE3;
  char fSSE4A;
  char fSSE4_1;
  char fSSE4_2;
  char fPOPCNT;
  char fLZCNT;
  char fTSC;
  char fTSCINV;
  char fTSCINV_BIT;
  char fAVX;
  char fAVX2;
  char fAES;
  char fERMS;
  char fCLMUL;
  char fBMI1;
  char fBMI2;
  char fRTM;
  char fADX;
  char fAVX512F;
  char fAVX512DQ;
  char fAVX512PF;
  char fAVX512ER;
  char fAVX512CD;
  char fAVX512BW;
  char fAVX512VL;
  char fSHA;
  char fFMA;
  char fVZEROUPPER;
  char fAVX512_VPOPCNTDQ;
  char fAVX512_VPCLMULQDQ;
  char fAVX512_VAES;
  char fAVX512_VNNI;
  char fFLUSH;
  char fFLUSHOPT;
  char fCLWB;
  char fAVX512_VBMI2;
  char fAVX512_VBMI;
  char fHV;
  char fSERIALIZE;
  char fRDTSCP;
  char fRDPID;
  char fFSRM;
  char fGFNI;
  char fAVX512_BITALG;
  char fPKU;
  char fOSPKE;
  char fCET_IBT;
  char fCET_SS;
  char fF16C;
  char fAVX512_IFMA;
} CPUFeatures;
