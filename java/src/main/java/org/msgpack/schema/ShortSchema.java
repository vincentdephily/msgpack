//
// MessagePack for Java
//
// Copyright (C) 2009-2010 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package org.msgpack.schema;

import java.io.IOException;
import org.msgpack.*;

public class ShortSchema extends Schema {
	public ShortSchema() { }

	@Override
	public String getClassName() {
		return "Short";
	}

	@Override
	public String getExpression() {
		return "short";
	}

	@Override
	public void pack(Packer pk, Object obj) throws IOException {
		if(obj instanceof Number) {
			int value = ((Number)obj).intValue();
			if(value > Short.MAX_VALUE) {
				throw new MessageTypeException();
			}
			pk.packShort((short)value);
		} else if(obj == null) {
			pk.packNil();
		} else {
			throw MessageTypeException.invalidConvert(obj, this);
		}
	}

	public static final short convertShort(Object obj) throws MessageTypeException {
		if(obj instanceof Number) {
			int value = ((Number)obj).intValue();
			if(value > Short.MAX_VALUE) {
				throw new MessageTypeException();
			}
			return (short)value;
		}
		throw new MessageTypeException();
	}

	@Override
	public Object convert(Object obj) throws MessageTypeException {
		return convertShort(obj);
	}

	@Override
	public Object createFromByte(byte v) {
		return (short)v;
	}

	@Override
	public Object createFromShort(short v) {
		return (short)v;
	}

	@Override
	public Object createFromInt(int v) {
		if(v > Short.MAX_VALUE) {
			throw new MessageTypeException();
		}
		return (short)v;
	}

	@Override
	public Object createFromLong(long v) {
		if(v > Short.MAX_VALUE) {
			throw new MessageTypeException();
		}
		return (short)v;
	}
}

