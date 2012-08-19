/*
 *   Copyright 2012 The Portico Project
 *
 *   This file is part of portico.
 *
 *   portico is free software; you can redistribute it and/or modify
 *   it under the terms of the Common Developer and Distribution License (CDDL) 
 *   as published by Sun Microsystems. For more information see the LICENSE file.
 *   
 *   Use of this software is strictly AT YOUR OWN RISK!!!
 *   If something bad happens you do not have permission to come crying to me.
 *   (that goes for your lawyer as well)
 *
 */
package org.portico.impl.hla1516e.types;

import hla.rti1516e.ParameterHandle;
import hla.rti1516e.ParameterHandleValueMap;
import hla.rti1516e.encoding.ByteWrapper;

import java.util.HashMap;

public class HLA1516eParameterHandleValueMap
       extends HashMap<ParameterHandle,byte[]>
       implements ParameterHandleValueMap
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	/**
	 * Returns a {@link ByteWrapper} around the byte[] mapped to the provided
	 * {@link ParameterHandle}, or null if there is no mapping for the key.
	 */
	public ByteWrapper getValueReference( ParameterHandle key )
	{
		byte[] value = super.get( key );
		if( value == null )
			return null;
		else
			return new ByteWrapper( value );
	}

	/**
	 * Finds the mapping for the provided {@link ParameterHandle} and update the
	 * provided {@link ByteWrapper} with it. The same wrapper is then returned.
	 * If there is no value for the attribute, null is returned.
	 */
	public ByteWrapper getValueReference( ParameterHandle key, ByteWrapper byteWrapper )
	{
		byte[] value = super.get( key );
		if( value == null )
			return null;
		
		// update the wrapper and return
		byteWrapper.reassign( value, 0, value.length );
		return byteWrapper;
	}

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
