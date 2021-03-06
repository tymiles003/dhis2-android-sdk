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

import org.hisp.dhis.client.sdk.android.api.persistence.flow.ProgramFlow;
import org.hisp.dhis.client.sdk.android.api.persistence.flow.ProgramIndicatorFlow;
import org.hisp.dhis.client.sdk.android.api.persistence.flow.ProgramStageFlow;
import org.hisp.dhis.client.sdk.android.api.persistence.flow.ProgramStageSectionFlow;
import org.hisp.dhis.client.sdk.android.common.AbsMapper;
import org.hisp.dhis.client.sdk.models.program.ProgramIndicator;

public class ProgramIndicatorMapper extends AbsMapper<ProgramIndicator, ProgramIndicatorFlow> {

    @Override
    public ProgramIndicatorFlow mapToDatabaseEntity(ProgramIndicator programIndicator) {
        if (programIndicator == null) {
            return null;
        }

        ProgramIndicatorFlow programIndicatorFlow = new ProgramIndicatorFlow();
        programIndicatorFlow.setId(programIndicator.getId());
        programIndicatorFlow.setUId(programIndicator.getUId());
        programIndicatorFlow.setCreated(programIndicator.getCreated());
        programIndicatorFlow.setLastUpdated(programIndicator.getLastUpdated());
        programIndicatorFlow.setName(programIndicator.getName());
        programIndicatorFlow.setDisplayName(programIndicator.getDisplayName());
        programIndicatorFlow.setAccess(programIndicator.getAccess());
        programIndicatorFlow.setCode(programIndicator.getCode());
        programIndicatorFlow.setExpression(programIndicator.getExpression());
        programIndicatorFlow.setDisplayDescription(programIndicator.getDisplayDescription());
        programIndicatorFlow.setRootDate(programIndicator.getRootDate());
        programIndicatorFlow.setExternalAccess(programIndicator.isExternalAccess());
        programIndicatorFlow.setValueType(programIndicator.getValueType());
        programIndicatorFlow.setDisplayShortName(programIndicator.getDisplayShortName());

        programIndicatorFlow.setProgram(ProgramFlow.MAPPER
                .mapToDatabaseEntity(programIndicator.getProgram()));
        programIndicatorFlow.setProgramStage(ProgramStageFlow.MAPPER
                .mapToDatabaseEntity(programIndicator.getProgramStage()));
        programIndicatorFlow.setProgramStageSection(ProgramStageSectionFlow.MAPPER
                .mapToDatabaseEntity(programIndicator.getProgramStageSection()));
        return programIndicatorFlow;
    }

    @Override
    public ProgramIndicator mapToModel(ProgramIndicatorFlow programIndicatorFlow) {
        if (programIndicatorFlow == null) {
            return null;
        }

        ProgramIndicator programIndicator = new ProgramIndicator();
        programIndicator.setId(programIndicatorFlow.getId());
        programIndicator.setUId(programIndicatorFlow.getUId());
        programIndicator.setCreated(programIndicatorFlow.getCreated());
        programIndicator.setLastUpdated(programIndicatorFlow.getLastUpdated());
        programIndicator.setName(programIndicatorFlow.getName());
        programIndicator.setDisplayName(programIndicatorFlow.getDisplayName());
        programIndicator.setAccess(programIndicatorFlow.getAccess());
        programIndicator.setCode(programIndicatorFlow.getCode());
        programIndicator.setExpression(programIndicatorFlow.getExpression());
        programIndicator.setDisplayDescription(programIndicatorFlow.getDisplayDescription());
        programIndicator.setRootDate(programIndicatorFlow.getRootDate());
        programIndicator.setExternalAccess(programIndicatorFlow.isExternalAccess());
        programIndicator.setValueType(programIndicatorFlow.getValueType());
        programIndicator.setDisplayShortName(programIndicatorFlow.getDisplayShortName());

        programIndicator.setProgram(ProgramFlow.MAPPER
                .mapToModel(programIndicatorFlow.getProgram()));
        programIndicator.setProgramStage(ProgramStageFlow.MAPPER
                .mapToModel(programIndicatorFlow.getProgramStage()));
        programIndicator.setProgramStageSection(ProgramStageSectionFlow.MAPPER
                .mapToModel(programIndicatorFlow.getProgramStageSection()));
        return programIndicator;
    }

    @Override
    public Class<ProgramIndicator> getModelTypeClass() {
        return ProgramIndicator.class;
    }

    @Override
    public Class<ProgramIndicatorFlow> getDatabaseEntityTypeClass() {
        return ProgramIndicatorFlow.class;
    }
}
