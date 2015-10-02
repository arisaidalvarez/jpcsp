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
package jpcsp.format.rco.type;

import jpcsp.format.rco.RCOContext;

public class EventType extends BaseReferenceType {
	public String event;

	@Override
	public void read(RCOContext context) {
		super.read(context);

		if (referenceType == REFERENCE_TYPE_EVENT) {
			event = context.events.get(value);
		} else if (referenceType != REFERENCE_TYPE_NONE) {
			log.warn(String.format("EventType unknown referenceType 0x%X", referenceType));
		}
	}

	@Override
	public String toString() {
		if (event == null) {
			return super.toString();
		}
		return String.format("%s, event='%s'", super.toString(), event);
	}
}