/*
Copyright 2016 S7connector members (github.com/s7connector)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.github.s7connector.test.example;

import com.github.s7connector.api.DaveArea;
import com.github.s7connector.api.S7Connector;
import com.github.s7connector.api.factory.S7ConnectorFactory;

/**
 * @author Thomas Rudin (thomas@rudin-informatik.ch)
 *
 */
public class PlainTutorialExample
{
	
	public static void main(String[] args) throws Exception
	{
		//Open TCP Connection
		S7Connector connector = 
				S7ConnectorFactory
				.buildTCPConnector()
				.withHost("10.0.0.220")
				.withRack(0)
				.withSlot(2)
				.build();
		
		//Read from DB100 10 bytes
		byte[] bs = connector.read(DaveArea.DB, 100, 10, 0);
		
		//Set some bytes
		bs[0] = 0x00;
		
		//Write to DB100 10 bytes
		connector.write(DaveArea.DB, 101, 0, bs);
		
		//Close connection
		connector.close();
	}

}
