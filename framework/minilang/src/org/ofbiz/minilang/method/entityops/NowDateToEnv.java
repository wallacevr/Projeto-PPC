/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package org.ofbiz.minilang.method.entityops;

import org.ofbiz.minilang.MiniLangException;
import org.ofbiz.minilang.SimpleMethod;
import org.ofbiz.minilang.method.ContextAccessor;
import org.ofbiz.minilang.method.MethodContext;
import org.ofbiz.minilang.method.MethodOperation;
import org.w3c.dom.Element;

/**
 * Creates a java.sql.Date with the current date and puts it in the env
 */
public class NowDateToEnv extends MethodOperation {

    ContextAccessor<java.sql.Date> envAcsr;

    public NowDateToEnv(Element element, SimpleMethod simpleMethod) throws MiniLangException {
        super(element, simpleMethod);
        envAcsr = new ContextAccessor<java.sql.Date>(element.getAttribute("field"), element.getAttribute("env-name"));
    }

    @Override
    public boolean exec(MethodContext methodContext) throws MiniLangException {
        envAcsr.put(methodContext, new java.sql.Date(System.currentTimeMillis()));
        return true;
    }

    @Override
    public String expandedString(MethodContext methodContext) {
        // TODO: something more than a stub/dummy
        return this.rawString();
    }

    @Override
    public String rawString() {
        // TODO: something more than the empty tag
        return "<now-date-to-env/>";
    }

    public static final class NowDateFactory implements Factory<NowDateToEnv> {
        public NowDateToEnv createMethodOperation(Element element, SimpleMethod simpleMethod) throws MiniLangException {
            return new NowDateToEnv(element, simpleMethod);
        }

        public String getName() {
            return "now-date";
        }
    }

    public static final class NowDateToEnvFactory implements Factory<NowDateToEnv> {
        public NowDateToEnv createMethodOperation(Element element, SimpleMethod simpleMethod) throws MiniLangException {
            return new NowDateToEnv(element, simpleMethod);
        }

        public String getName() {
            return "now-date-to-env";
        }
    }
}
