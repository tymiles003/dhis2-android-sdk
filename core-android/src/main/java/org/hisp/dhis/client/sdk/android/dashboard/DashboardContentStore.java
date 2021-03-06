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

package org.hisp.dhis.client.sdk.android.dashboard;

import org.hisp.dhis.client.sdk.android.api.persistence.flow.DashboardContentFlow;
import org.hisp.dhis.client.sdk.android.common.AbsIdentifiableObjectStore;
import org.hisp.dhis.client.sdk.android.common.IMapper;
import org.hisp.dhis.client.sdk.core.dashboard.IDashboardItemContentStore;
import org.hisp.dhis.client.sdk.models.dashboard.DashboardContent;

import java.util.List;

public final class DashboardContentStore extends AbsIdentifiableObjectStore<DashboardContent,
        DashboardContentFlow> implements IDashboardItemContentStore {

    public DashboardContentStore(IMapper<DashboardContent, DashboardContentFlow> contentMapper) {
        super(contentMapper);
    }

    @Override
    public List<DashboardContent> queryByTypes(List<String> types) {
//        CombinedCondition generalCondition = CombinedCondition.begin(
//                Condition.column(DashboardContent_Flow_Table.TYPE).isNotNull());
//        CombinedCondition columnConditions = null;
//        for (String type : types) {
//            if (columnConditions == null) {
//                columnConditions = CombinedCondition
//                        .begin(Condition.column(DashboardContent_Flow_Table.TYPE).is(type));
//            } else {
//                columnConditions = columnConditions
//                        .or(Condition.column(DashboardContent_Flow_Table.TYPE).is(type));
//            }
//        }
//        generalCondition.and(columnConditions);
//
//        List<DashboardContent_Flow> resources = new Select()
//                .from(DashboardContent_Flow.class)
//                .where(generalCondition)
//                .queryList();
//        return getMapper().mapToModels(resources);
        return null;
    }
}
