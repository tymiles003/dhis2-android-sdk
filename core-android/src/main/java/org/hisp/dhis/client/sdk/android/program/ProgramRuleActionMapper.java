/*
 * Copyright (c) 2016, University of Oslo
 *
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.hisp.dhis.client.sdk.android.program;

import org.hisp.dhis.client.sdk.android.api.persistence.MapperModuleProvider;
import org.hisp.dhis.client.sdk.android.api.persistence.flow.ProgramRuleActionFlow;
import org.hisp.dhis.client.sdk.android.api.persistence.flow.ProgramStageFlow;
import org.hisp.dhis.client.sdk.android.api.persistence.flow.ProgramStageSectionFlow;
import org.hisp.dhis.client.sdk.android.common.AbsMapper;
import org.hisp.dhis.client.sdk.models.program.ProgramRuleAction;

public class ProgramRuleActionMapper extends AbsMapper<ProgramRuleAction, ProgramRuleActionFlow> {

    public ProgramRuleActionMapper() {
        // empty constructor
    }

    @Override
    public ProgramRuleActionFlow mapToDatabaseEntity(ProgramRuleAction programRuleAction) {
        if (programRuleAction == null) {
            return null;
        }

        ProgramRuleActionFlow programRuleActionFlow = new ProgramRuleActionFlow();
        programRuleActionFlow.setId(programRuleAction.getId());
        programRuleActionFlow.setUId(programRuleAction.getUId());
        programRuleActionFlow.setCreated(programRuleAction.getCreated());
        programRuleActionFlow.setLastUpdated(programRuleAction.getLastUpdated());
        programRuleActionFlow.setName(programRuleAction.getName());
        programRuleActionFlow.setDisplayName(programRuleAction.getDisplayName());
        programRuleActionFlow.setAccess(programRuleAction.getAccess());
        programRuleActionFlow.setProgramRule(MapperModuleProvider.getInstance()
                .getProgramRuleMapper().mapToDatabaseEntity(programRuleAction.getProgramRule()));
        programRuleActionFlow.setTrackedEntityAttribute(MapperModuleProvider.getInstance()
                .getTrackedEntityAttributeMapper().mapToDatabaseEntity(programRuleAction
                        .getTrackedEntityAttribute()));
        programRuleActionFlow.setDataElement(MapperModuleProvider.getInstance()
                .getDataElementMapper().mapToDatabaseEntity(programRuleAction.getDataElement()));
        programRuleActionFlow.setProgramIndicator(MapperModuleProvider.getInstance()
                .getProgramIndicatorMapper().mapToDatabaseEntity(programRuleAction
                        .getProgramIndicator()));
        programRuleActionFlow.setProgramStage(ProgramStageFlow.MAPPER
                .mapToDatabaseEntity(programRuleAction.getProgramStage()));
        programRuleActionFlow.setProgramStageSection(ProgramStageSectionFlow.MAPPER
                .mapToDatabaseEntity(programRuleAction.getProgramStageSection()));
        programRuleActionFlow.setProgramRuleActionType(programRuleAction.getProgramRuleActionType
                ());
        programRuleActionFlow.setContent(programRuleAction.getContent());
        programRuleActionFlow.setLocation(programRuleAction.getLocation());
        programRuleActionFlow.setData(programRuleAction.getData());
        return programRuleActionFlow;
    }

    @Override
    public ProgramRuleAction mapToModel(ProgramRuleActionFlow programRuleActionFlow) {
        if (programRuleActionFlow == null) {
            return null;
        }

        ProgramRuleAction programRuleAction = new ProgramRuleAction();
        programRuleAction.setId(programRuleActionFlow.getId());
        programRuleAction.setUId(programRuleActionFlow.getUId());
        programRuleAction.setCreated(programRuleActionFlow.getCreated());
        programRuleAction.setLastUpdated(programRuleActionFlow.getLastUpdated());
        programRuleAction.setName(programRuleActionFlow.getName());
        programRuleAction.setDisplayName(programRuleActionFlow.getDisplayName());
        programRuleAction.setAccess(programRuleActionFlow.getAccess());
        programRuleAction.setProgramRule(MapperModuleProvider.getInstance().getProgramRuleMapper
                ().mapToModel(programRuleActionFlow.getProgramRule()));
        programRuleAction.setTrackedEntityAttribute(MapperModuleProvider.getInstance()
                .getTrackedEntityAttributeMapper().mapToModel(programRuleActionFlow
                        .getTrackedEntityAttribute()));
        programRuleAction.setDataElement(MapperModuleProvider.getInstance().getDataElementMapper
                ().mapToModel(programRuleActionFlow.getDataElement()));
        programRuleAction.setProgramIndicator(MapperModuleProvider.getInstance()
                .getProgramIndicatorMapper().mapToModel(programRuleActionFlow.getProgramIndicator
                        ()));
        programRuleAction.setProgramStage(ProgramStageFlow.MAPPER.
                mapToModel(programRuleActionFlow.getProgramStage()));
        programRuleAction.setProgramStageSection(ProgramStageSectionFlow.MAPPER
                .mapToModel(programRuleActionFlow.getProgramStageSection()));
        programRuleAction.setProgramRuleActionType(programRuleActionFlow.getProgramRuleActionType
                ());
        programRuleAction.setContent(programRuleActionFlow.getContent());
        programRuleAction.setLocation(programRuleActionFlow.getLocation());
        programRuleAction.setData(programRuleActionFlow.getData());
        return programRuleAction;
    }

    @Override
    public Class<ProgramRuleAction> getModelTypeClass() {
        return ProgramRuleAction.class;
    }

    @Override
    public Class<ProgramRuleActionFlow> getDatabaseEntityTypeClass() {
        return ProgramRuleActionFlow.class;
    }
}
