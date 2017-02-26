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

public class TypeInfo {
	public boolean isSimple = false;
	public boolean isArray = false;
	public boolean isEnumerable = false;
	public boolean isCollection = false;
	public boolean isDictionary = false;
	public Class type;
	public String cSharpType;
	public Class elementType;
	public String cSharpElementType;
	public Class keyType;
	public String cSharpKeyType;
	public int dimensionCount;
}
