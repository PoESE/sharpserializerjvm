/**
 *  Eternity Keeper, a Pillars of Eternity save game editor.
 *  Copyright (C) 2015 the authors.
 *
 *  Eternity Keeper is free software: you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  Eternity Keeper is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package sx.kenji.sharpserializerjvm;

import com.google.common.primitives.UnsignedInteger;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

class TypeMap {
	static final Map<String, Class> map = new HashMap<String, Class>() {{
		put("System.Boolean", boolean.class);
		put("System.Guid", UUID.class);
		put("System.Int32", int.class);
		put("System.Object", Object.class);
		put("System.Single", float.class);
		put("System.String", String.class);
		put("System.UInt32", UnsignedInteger.class);

		put("System.Boolean[]", Boolean[].class);
		put("System.Byte[]", Byte[].class);
		put("System.Int32[]", Integer[].class);
		put("System.Int32[][]", Integer[][].class);
		put("System.Single[]", Float[].class);

		put("System.Collections.Generic.Dictionary", HashMap.class);
		put("System.Collections.Generic.List", CSharpCollection.class);
		put("System.Collections.Generic.SortedList", SortedList.class);
		put("System.Collections.Hashtable", Hashtable.class);
	}};
}
