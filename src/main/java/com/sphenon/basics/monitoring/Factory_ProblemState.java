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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.validation.returncodes.*;

public class Factory_ProblemState {
    private String state;
    private boolean state_is_valid = false;
    private ProblemState problem_state = null;

    public void setState(CallContext context, String state) {
        this.state = state;

        this.state_is_valid = true;

        if (this.state.equals("IDLE"                      )) { this.problem_state = ProblemState.IDLE                      ; return; }
        if (this.state.equals("IDLE_INCOMPLETE"           )) { this.problem_state = ProblemState.IDLE_INCOMPLETE           ; return; }
        if (this.state.equals("OK"                        )) { this.problem_state = ProblemState.OK                        ; return; }
        if (this.state.equals("OK_INCOMPLETE"             )) { this.problem_state = ProblemState.OK_INCOMPLETE             ; return; }
        if (this.state.equals("INFO"                      )) { this.problem_state = ProblemState.INFO                      ; return; }
        if (this.state.equals("INFO_INCOMPLETE"           )) { this.problem_state = ProblemState.INFO_INCOMPLETE           ; return; }
        if (this.state.equals("NOTICE"                    )) { this.problem_state = ProblemState.NOTICE                    ; return; }
        if (this.state.equals("NOTICE_INCOMPLETE"         )) { this.problem_state = ProblemState.NOTICE_INCOMPLETE         ; return; }
        if (this.state.equals("WARNING"                   )) { this.problem_state = ProblemState.WARNING                   ; return; }
        if (this.state.equals("WARNING_INCOMPLETE"        )) { this.problem_state = ProblemState.WARNING_INCOMPLETE        ; return; }
        if (this.state.equals("SEVERE_WARNING"            )) { this.problem_state = ProblemState.SEVERE_WARNING            ; return; }
        if (this.state.equals("SEVERE_WARNING_INCOMPLETE" )) { this.problem_state = ProblemState.SEVERE_WARNING_INCOMPLETE ; return; }
        if (this.state.equals("ERROR"                     )) { this.problem_state = ProblemState.ERROR                     ; return; }
        if (this.state.equals("ERROR_INCOMPLETE"          )) { this.problem_state = ProblemState.ERROR_INCOMPLETE          ; return; }
        if (this.state.equals("CRITICAL_ERROR"            )) { this.problem_state = ProblemState.CRITICAL_ERROR            ; return; }
        if (this.state.equals("CRITICAL_ERROR_INCOMPLETE" )) { this.problem_state = ProblemState.CRITICAL_ERROR_INCOMPLETE ; return; }
        if (this.state.equals("FATAL_ERROR"               )) { this.problem_state = ProblemState.FATAL_ERROR               ; return; }
        if (this.state.equals("FATAL_ERROR_INCOMPLETE"    )) { this.problem_state = ProblemState.FATAL_ERROR_INCOMPLETE    ; return; }
        if (this.state.equals("EMERGENCY"                 )) { this.problem_state = ProblemState.EMERGENCY                 ; return; }
        if (this.state.equals("EMERGENCY_INCOMPLETE"      )) { this.problem_state = ProblemState.EMERGENCY_INCOMPLETE      ; return; }
        if (this.state.equals("PANIC"                     )) { this.problem_state = ProblemState.PANIC                     ; return; }
        if (this.state.equals("PANIC_INCOMPLETE"          )) { this.problem_state = ProblemState.PANIC_INCOMPLETE          ; return; }

        this.state_is_valid = false;
        this.problem_state = null;
    }

    public void validateState(CallContext context) throws ValidationFailure {
        if (! this.state_is_valid) {
            ValidationFailure.createAndThrow (context, MonitoringStringPool.get(context, "0.0.0" /* Invalid state parameter for Factory_ProblemState, got '%(got)', expected one of UNKNOWN, OK, INFO, NOTICE, WARNING, SEVERE_WARNING, ERROR, CRITICAL_ERROR, FATAL_ERROR, EMERGENCY, PANIC */), "got", this.state);
            throw (ValidationFailure) null; // compiler insists
        }
    }

    public ProblemState create (CallContext call_context) {
        Context context = Context.create(call_context);
        CustomaryContext cc = CustomaryContext.create(context);
        try {
            this.validateState(context);
        } catch (ValidationFailure vf) {
            cc.throwPreConditionViolation(context, vf, MonitoringStringPool.get(context, "0.0.1" /* At least one factory parameter is invalid */));
            throw (ExceptionPreConditionViolation) null;
        }

        return this.problem_state;
    }
}
