/* $Id$ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
* 
* http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.acf.crawler;

import java.io.*;
import org.apache.acf.core.interfaces.*;
import org.apache.acf.crawler.interfaces.*;
import org.apache.acf.crawler.system.*;
import java.util.*;

/** This class is used during testing.
*/
public class CheckConfigured
{
        public static final String _rcsid = "@(#)$Id$";

        private CheckConfigured()
        {
        }

        // Add: throttle, priority, recrawl interval

        public static void main(String[] args)
        {
                if (args.length != 0)
                {
                        System.err.println("Usage: CheckConfigured");
                        System.exit(1);
                }

                try
                {
                        ACF.initializeEnvironment();
                        IThreadContext tc = ThreadContextFactory.make();
                        IRepositoryConnectionManager connManager = RepositoryConnectionManagerFactory.make(tc);
                        if (connManager.getAllConnections().length > 0)
                                UTF8Stdout.println("CONFIGURED");
                        else
                                UTF8Stdout.println("OK");
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        System.exit(2);
                }
        }
                
}
