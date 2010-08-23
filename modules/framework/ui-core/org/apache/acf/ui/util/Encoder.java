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
package org.apache.acf.ui.util;

/** Various useful encoding methods for working with html
*/
public class Encoder
{
  public static final String _rcsid = "@(#)$Id$";

  /** Escape a string that's inside an html attribute and thence inside javascript.
  *@param value is the input.
  *@return the escaped string.
  */
  public static String attributeJavascriptEscape(String value)
  {
    StringBuffer rval = new StringBuffer();
    int i = 0;
    while (i < value.length())
    {
      char x = value.charAt(i++);
      // First level of encoding: javascript string
      if (x == '\\' || x == '"' || x == '\'')
      {
        rval.append("\\").append(x);
      }
      else
        rval.append(x);
    }
    return attributeEscape(rval.toString());
  }

  /** Escape a string that's inside an html attribute.
  *@param value is the input.
  *@return the escaped string.
  */
  public static String attributeEscape(String value)
  {
    StringBuffer rval = new StringBuffer();
    int i = 0;
    while (i < value.length())
    {
      char x = value.charAt(i++);
      if (x == '\'' || x == '"' || x == '<' || x == '>' || x == '&'|| (x < ' ' && x >= 0))
      {
        rval.append("&#").append(Integer.toString((int)x)).append(";");
      }
      else
        rval.append(x);
    }
    return rval.toString();
  }

  /** Escape a string that's inside an html body.
  *@param value is the input.
  *@return the escaped string.
  */
  public static String bodyEscape(String value)
  {
    StringBuffer rval = new StringBuffer();
    int i = 0;
    while (i < value.length())
    {
      char x = value.charAt(i++);
      if (x == '<' || x == '>' || x == '&' || (x < ' ' && x >= 0))
      {
        rval.append("&#").append(Integer.toString((int)x)).append(";");
      }
      else
        rval.append(x);
    }
    return rval.toString();
  }

}
