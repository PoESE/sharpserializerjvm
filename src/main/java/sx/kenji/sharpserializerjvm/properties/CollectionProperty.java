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

public class CollectionProperty extends ComplexProperty {
	private static final Logger logger = LoggerFactory.getLogger(CollectionProperty.class);
	public List<Property> items = new ArrayList<>();
	public TypePair elementType;

	public CollectionProperty (String name, TypePair type) {
		super(name, type);
	}

	@Override
	public PropertyArt getPropertyArt () {
		return PropertyArt.Collection;
	}

	@Override
	public void makeFlatCopyFrom (ReferenceTargetProperty source) {
		if (source instanceof CollectionProperty) {
			super.makeFlatCopyFrom(source);
			elementType = ((CollectionProperty) source).elementType;
			items = ((CollectionProperty) source).items;
		} else {
			logger.error(
				"Tried to make CollectionProperty flat copy of `{}`."
				, source.getClass().getSimpleName());
		}
	}
}
