/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.ide.common.server.factconstraints.predefined;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.drools.ide.common.client.factconstraints.ConstraintConfiguration;
import org.drools.ide.common.server.factconstraints.DefaultFieldConstraintImpl;

public class MatchesConstraint extends DefaultFieldConstraintImpl {

    public static final String MATCHES_ARGUMENT = "matches";
    private static final long serialVersionUID = 501l;
    public static final String NAME = "Matches";

    @Override
    protected String internalVerifierRule(ConstraintConfiguration config, Map<String, Object> context) {
        List<String> constraints = new ArrayList<String>();
        constraints.add("valueAsString not matches \"" + config.getArgumentValue(MATCHES_ARGUMENT) + "\"");

        return this.createVerifierRuleTemplate(config, context,
                "Matches_Field_Constraint", constraints,
                "The value must match: " + config.getArgumentValue(MATCHES_ARGUMENT)); // I18N
    }

}
