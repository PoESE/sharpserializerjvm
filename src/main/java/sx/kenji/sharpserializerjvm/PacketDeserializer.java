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
import sx.kenji.sharpserializerjvm.properties.ReferenceTargetProperty;
import sx.kenji.sharpserializerjvm.properties.SimpleProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// This is a specialised instance of the Deserializer when we know we are dealing with a file that
// has been serialized in PoE's particular format (i.e. the first object is a plain integer of the
// number of following ComponentPersistencePacket objects).

public class PacketDeserializer {
	private final SharpSerializer deserializer;

	public PacketDeserializer (final File file) throws FileNotFoundException {
		deserializer = new SharpSerializer(file.getAbsolutePath());
	}

	public PacketDeserializer (final String filename) throws FileNotFoundException {
		this(new File(filename));
	}

	PacketDeserializer(final SharpSerializer sharpSerializer) {
		this.deserializer = sharpSerializer;
	}

	public Optional<Property> followReference (final ReferenceTargetProperty property) {
		return deserializer.followReference(property);
	}

	public Optional<DeserializedPackets> deserialize () throws FileNotFoundException {
		final List<Property> deserialized = new ArrayList<>();
		final Optional<Property> objCountProp = deserializer.deserialize();

		if (!objCountProp.isPresent()) {
			return Optional.empty();
		}

		final int count = (int) objCountProp.get().obj;
		for (int i = 0; i < count; i++) {
			final Optional<Property> property = deserializer.deserialize();
			if (property.isPresent()) {
				deserialized.add(property.get());
			}
		}

		final SimpleProperty countProperty = (SimpleProperty) objCountProp.get();
		return Optional.of(new DeserializedPackets(deserialized, countProperty));
	}

	public void addTypes(Map<String, Class> types) {
	    this.deserializer.addTypes(types);
	}
}
