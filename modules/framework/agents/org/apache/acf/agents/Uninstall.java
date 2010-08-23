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
package org.apache.acf.agents;

import org.apache.acf.core.interfaces.*;
import org.apache.acf.agents.system.*;

/**
 * Use to uninstall the agent. Results in cleaning up the persistent storage.
 */
public class Uninstall extends BaseAgentsInitializationCommand
{
  public static final String _rcsid = "@(#)$Id$";

  public Uninstall()
  {
  }

  protected void doExecute(IThreadContext tc) throws ACFException
  {
    ACF.deinstallTables(tc);
    Logging.root.info("Agent tables uninstalled");
  }

  public static void main(String[] args)
  {
    if (args.length > 0)
    {
      System.err.println("Usage: Uninstall");
      System.exit(1);
    }

    try
    {
      Uninstall uninstall = new Uninstall();
      uninstall.execute();
      System.err.println("Agent tables uninstalled");
    }
    catch (ACFException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
