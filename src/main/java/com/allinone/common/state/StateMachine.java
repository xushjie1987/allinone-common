/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.allinone.common.state;

/**
 * ClassName: StateMachine <br/>
 * Function: <br/>
 * date: 2016年12月31日 下午9:27:22 <br/>
 *
 * @author shengjie
 * @version @param <STATE>
 * @version @param <EVENTTYPE>
 * @version @param <EVENT>
 * @since JDK 1.8
 */
public interface StateMachine<STATE extends Enum<STATE>, EVENTTYPE extends Enum<EVENTTYPE>, EVENT> {
    /**
     * getCurrentState: <br/>
     * 
     * @author shengjie
     * @return
     * @since JDK 1.8
     */
    public STATE getCurrentState();
    
    /**
     * doTransition: <br/>
     * 
     * @author shengjie
     * @param eventType
     * @param event
     * @return
     * @throws InvalidStateTransitonException
     * @since JDK 1.8
     */
    public STATE doTransition(EVENTTYPE eventType,
                              EVENT event) throws InvalidStateTransitonException;
}
