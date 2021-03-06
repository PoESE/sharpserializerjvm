/**
 * Eternity Keeper, a Pillars of Eternity save game editor.
 * Copyright (C) 2015 the authors.
 * <p>
 * Eternity Keeper is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p>
 * Eternity Keeper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package sx.kenji.sharpserializerjvm;

import sx.kenji.sharpserializerjvm.properties.Property;
import sx.kenji.sharpserializerjvm.properties.SimpleProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class DeserializedPackets {
	private List<Property> packets;
	private final SimpleProperty count;

	public DeserializedPackets (final List<Property> packets, final SimpleProperty count) {
		this.packets = packets;
		this.count = count;
	}

	public List<Property> getPackets () {
		return packets;
	}

	public void setPackets (final List<Property> packets) {
		this.packets = packets;
	}

	public SimpleProperty getCount () {
		return count;
	}

	public void reserialize (final File destinationFile) throws FileNotFoundException {
		this.reserialize(new SharpSerializer(destinationFile.getAbsolutePath()));
	}

	void reserialize(final SharpSerializer serializer) {
		serializer.serialize(count);
		for (final Property property : packets) {
			serializer.serialize(property);
		}
	}
}
