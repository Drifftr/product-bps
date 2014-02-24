/**
 *  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.bpel.extension.logger;

import org.apache.ode.bpel.common.FaultException;
import org.apache.ode.bpel.runtime.extension.AbstractSyncExtensionOperation;
import org.apache.ode.bpel.runtime.extension.ExtensionContext;
import org.w3c.dom.Element;

public class LoggerExtensionOperation extends AbstractSyncExtensionOperation {

    @Override
    protected void runSync(ExtensionContext extensionContext, Element element) throws FaultException {


        LogActivity logActivity = new LogActivity(extensionContext, element);
            try {
                logActivity.runLogActivity();
            } catch (FaultException e) {
                String errMsg = "Variable logging activity failed.";
                LogActivity.log.error(errMsg, e);
            }
    }
}
