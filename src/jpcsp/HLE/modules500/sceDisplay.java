/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */

package jpcsp.HLE.modules500;

import jpcsp.HLE.HLEFunction;
import org.lwjgl.LWJGLException;

import jpcsp.Processor;
import jpcsp.Allegrex.CpuState;
import jpcsp.HLE.kernel.managers.IntrManager;
import jpcsp.HLE.kernel.types.SceKernelErrors;

public class sceDisplay extends jpcsp.HLE.modules200.sceDisplay {
	private static final long serialVersionUID = 5006833555228054367L;

	public sceDisplay() throws LWJGLException {
		super();
	}

	@Override
	public String getName() { return "sceDisplay"; }


	@HLEFunction(nid = 0x40F1469C, version = 500)
	public void sceDisplayWaitVblankStartMulti(Processor processor) {
		CpuState cpu = processor.cpu;

		int cycleNum = cpu.gpr[4];  // Number of VSYNCs to wait before blocking the thread on VBLANK.

        if(log.isDebugEnabled()) {
            log.debug("sceDisplayWaitVblankStartMulti cycleNum=" + cycleNum);
        }

        if (IntrManager.getInstance().isInsideInterrupt()) {
            cpu.gpr[2] = SceKernelErrors.ERROR_KERNEL_CANNOT_BE_CALLED_FROM_INTERRUPT;
            return;
        }
        cpu.gpr[2] = 0;
        blockCurrentThreadOnVblank(cycleNum, false);
	}

	@HLEFunction(nid = 0x77ED8B3A, version = 500)
	public void sceDisplayWaitVblankStartMultiCB(Processor processor) {
		CpuState cpu = processor.cpu;

		int cycleNum = cpu.gpr[4];   // Number of VSYNCs to wait before blocking the thread on VBLANK.

        if(log.isDebugEnabled()) {
            log.debug("sceDisplayWaitVblankStartMultiCB cycleNum=" + cycleNum);
        }

        if (IntrManager.getInstance().isInsideInterrupt()) {
            cpu.gpr[2] = SceKernelErrors.ERROR_KERNEL_CANNOT_BE_CALLED_FROM_INTERRUPT;
            return;
        }
        cpu.gpr[2] = 0;
        blockCurrentThreadOnVblank(cycleNum, true);
	}

}