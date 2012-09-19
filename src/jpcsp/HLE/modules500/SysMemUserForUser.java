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

public class SysMemUserForUser extends jpcsp.HLE.modules395.SysMemUserForUser {
	@HLEFunction(nid = 0x91DE343C, version = 500)
	public int sceKernelSetCompiledSdkVersion500_505(int sdkVersion) {
        if (log.isDebugEnabled()) {
            log.debug(String.format("sceKernelSetCompiledSdkVersion500_505: sdkVersion=%08X", sdkVersion));
        }

        hleSetCompiledSdkVersion(sdkVersion);

        return 0;
	}

}