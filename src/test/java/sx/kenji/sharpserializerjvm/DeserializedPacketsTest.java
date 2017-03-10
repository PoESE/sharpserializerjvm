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

import org.junit.Test;
import org.mockito.InOrder;
import sx.kenji.sharpserializerjvm.properties.Property;
import sx.kenji.sharpserializerjvm.properties.SimpleProperty;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.inOrder;

public class DeserializedPacketsTest {
	@Test
	public void testReserialize() {
		final SharpSerializer mockSerializer = mock(SharpSerializer.class);
		final File mockFile = mock(File.class);
		final Property mockProperty = mock(Property.class);
		final SimpleProperty mockCount = mock(SimpleProperty.class);
		final List<Property> components = new ArrayList<Property>() {{add(mockProperty);}};
		final DeserializedPackets deserialized =
			new DeserializedPackets(components, mockCount);

		when(mockFile.getAbsolutePath()).thenReturn("");
		deserialized.reserialize(mockSerializer);

		final InOrder inOrder = inOrder(mockSerializer);
		inOrder.verify(mockSerializer).serialize(mockCount);
		inOrder.verify(mockSerializer).serialize(mockProperty);
	}
}
