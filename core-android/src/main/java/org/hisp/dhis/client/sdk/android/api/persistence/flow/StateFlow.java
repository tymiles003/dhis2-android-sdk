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

package org.hisp.dhis.client.sdk.android.api.persistence.flow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.annotation.UniqueGroup;
import com.raizlabs.android.dbflow.structure.Model;

import org.hisp.dhis.client.sdk.android.api.persistence.DbDhis;
import org.hisp.dhis.client.sdk.android.common.AbsMapper;
import org.hisp.dhis.client.sdk.android.common.IStateMapper;
import org.hisp.dhis.client.sdk.models.common.base.IModel;
import org.hisp.dhis.client.sdk.models.common.state.State;
import org.hisp.dhis.client.sdk.models.event.Event;

import static org.hisp.dhis.client.sdk.models.utils.Preconditions.isNull;

@Table(database = DbDhis.class,
        uniqueColumnGroups = {
                @UniqueGroup(
                        groupNumber = StateFlow.UNIQUE_GROUP_NUMBER,
                        uniqueConflict = ConflictAction.REPLACE)
        }
)
public final class StateFlow extends BaseModelFlow {
    public static final IStateMapper MAPPER = new StateMapper();
    static final int UNIQUE_GROUP_NUMBER = 1;

    @Column(name = "itemId")
    @Unique(unique = false, uniqueGroups = {UNIQUE_GROUP_NUMBER})
    long itemId;

    @Column(name = "itemType")
    @Unique(unique = false, uniqueGroups = {UNIQUE_GROUP_NUMBER})
    String itemType;

    // We need to specify FQCN in order to avoid collision with BaseMode.Action class.
    @Column(name = "action")
    org.hisp.dhis.client.sdk.models.common.state.Action action;

    public StateFlow() {
        // empty constructor
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public org.hisp.dhis.client.sdk.models.common.state.Action getAction() {
        return action;
    }

    public void setAction(org.hisp.dhis.client.sdk.models.common.state.Action action) {
        this.action = action;
    }

    private static class StateMapper extends AbsMapper<State, StateFlow> implements IStateMapper {

        @Override
        public StateFlow mapToDatabaseEntity(State state) {
            if (state == null) {
                return null;
            }

            StateFlow stateFlow = new StateFlow();
            stateFlow.setItemId(state.getItemId());
            stateFlow.setItemType(getRelatedModelClass(state.getItemType()));
            stateFlow.setAction(state.getAction());

            return stateFlow;
        }

        @Override
        public State mapToModel(StateFlow stateFlow) {
            if (stateFlow == null) {
                return null;
            }

            State state = new State();
            state.setItemId(stateFlow.getItemId());
            state.setItemType(getRelatedModelClass(stateFlow.getItemType()));
            state.setAction(stateFlow.getAction());

            return state;
        }

        @Override
        public Class<State> getModelTypeClass() {
            return State.class;
        }

        @Override
        public Class<StateFlow> getDatabaseEntityTypeClass() {
            return StateFlow.class;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Class<? extends IModel> getRelatedModelClass(String type) {
            isNull(type, "type must not be null");

            try {
                return (Class<? extends IModel>) Class.forName(type);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String getRelatedModelClass(Class<? extends IModel> clazz) {
            isNull(clazz, "class object must not be null");
            return clazz.getName();
        }

        @Override
        public Class<? extends Model> getRelatedDatabaseEntityClass(
                Class<? extends IModel> objectClass) {
            isNull(objectClass, "Class object must not be null");

            if (Event.class.equals(objectClass)) {
                return EventFlow.class;
            }

            throw new IllegalArgumentException("Unsupported type: " + objectClass.getSimpleName());
        }
    }
}
