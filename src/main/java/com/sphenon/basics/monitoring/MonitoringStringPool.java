package com.sphenon.basics.monitoring;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.classes.*;

public class MonitoringStringPool extends StringPoolClass {
    static protected MonitoringStringPool singleton = null;

    static public MonitoringStringPool getSingleton (CallContext cc) {
        if (singleton == null) {
            singleton = new MonitoringStringPool(cc);
        }
        return singleton;
    }

    static public VariativeString get(CallContext cc, String id) {
        return VariativeStringClass.createVariativeStringClass(cc, id, getSingleton(cc));
    }

    static public String get(CallContext cc, String id, String isolang) {
        return getSingleton(cc).getString(cc, id, isolang);
    }

    protected MonitoringStringPool (CallContext cc) {
        super(cc);
        /*************************************************/
        /* THE FOLLOWING SECTION IS PARTIALLY GENERATED. */
        /* BE CAREFUL WHEN EDITING MANUALLY !            */
        /*                                               */
        /* See StringPool.java for explanation.          */
        /*************************************************/
        //BEGINNING-OF-STRINGS
        //P-0-com.sphenon.basics.monitoring
        //F-0-0-Factory_ProblemState.java
        addEntry(cc, "0.0.0", "en", "Invalid state parameter for Factory_ProblemState, got '%(got)', expected one of UNKNOWN, OK, INFO, NOTICE, WARNING, SEVERE_WARNING, ERROR, CRITICAL_ERROR, FATAL_ERROR, EMERGENCY, PANIC");
        addEntry(cc, "0.0.0", "en", "Ungültiger Zustands-Parameter für Factory_ProblemState, erhalten '%(got)', erwartet wurde einer der folgenden Werte: UNKNOWN, OK, INFO, NOTICE, WARNING, SEVERE_WARNING, ERROR, CRITICAL_ERROR, FATAL_ERROR, EMERGENCY, PANIC");
        addEntry(cc, "0.0.1", "en", "At least one factory parameter is invalid");
        addEntry(cc, "0.0.1", "de", "Mindestens ein Fabrik-Parameter ist ungültig");
        //END-OF-STRINGS
        /*************************************************/
    }
}
