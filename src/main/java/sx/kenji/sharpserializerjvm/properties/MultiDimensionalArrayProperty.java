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


package sx.kenji.sharpserializerjvm.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.kenji.sharpserializerjvm.TypePair;

import java.util.ArrayList;
import java.util.List;

public class MultiDimensionalArrayProperty extends ReferenceTargetProperty {
	private static final Logger logger = LoggerFactory.getLogger(MultiDimensionalArrayProperty.class);
	public TypePair elementType;
	public List<MultiDimensionalArrayItem> items = new ArrayList<>();
	public List<ArrayDimension> dimensions = new ArrayList<>();

	public MultiDimensionalArrayProperty (String name, TypePair type) {
		super(name, type);
	}

	@Override
	public void makeFlatCopyFrom (ReferenceTargetProperty source) {
		if (source instanceof MultiDimensionalArrayProperty) {
			super.makeFlatCopyFrom(source);
			elementType = ((MultiDimensionalArrayProperty) source).elementType;
			dimensions = ((MultiDimensionalArrayProperty) source).dimensions;
			items = ((MultiDimensionalArrayProperty) source).items;
		} else {
			logger.error(
				"Tried to make MultiDimensionalArray flat copy of `{}`."
				, source.getClass().getSimpleName());
		}
	}

	@Override
	public PropertyArt getPropertyArt () {
		return PropertyArt.MultiDimensionalArray;
	}

	public static class MultiDimensionalArrayItem {
		public int[] indexes;
		public Property value;

		public MultiDimensionalArrayItem (int[] indexes, Property value) {
			this.indexes = indexes;
			this.value = value;
		}
	}

	public static class ArrayDimension {
		public int lowerBound;
		public int length;

		public ArrayDimension () {}

		public ArrayDimension (int lowerBound, int length) {
			this.lowerBound = lowerBound;
			this.length = length;
		}
	}
}
