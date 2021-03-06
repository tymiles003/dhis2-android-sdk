package org.hisp.dhis.client.sdk.android.event;

import org.hisp.dhis.client.sdk.android.api.network.ApiResource;
import org.hisp.dhis.client.sdk.core.common.Fields;
import org.hisp.dhis.client.sdk.core.common.network.ApiException;
import org.hisp.dhis.client.sdk.core.common.network.ApiResponse;
import org.hisp.dhis.client.sdk.core.event.IEventApiClient;
import org.hisp.dhis.client.sdk.models.event.Event;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;

import static org.hisp.dhis.client.sdk.android.api.network.NetworkUtils.call;
import static org.hisp.dhis.client.sdk.android.api.network.NetworkUtils.getCollection;

public class EventApiClient implements IEventApiClient {
    private final EventApiClientRetrofit eventApiclientRetrofit;

    public EventApiClient(EventApiClientRetrofit eventApiclientRetrofit) {
        this.eventApiclientRetrofit = eventApiclientRetrofit;
    }

    @Override
    public List<Event> getEvents(
            Fields fields, DateTime lastUpdated, Set<String> uids) throws ApiException {
        ApiResource<Event> apiResource = new ApiResource<Event>() {

            @Override
            public String getResourceName() {
                return "events";
            }

            @Override
            public String getBasicProperties() {
                return "event";
            }

            @Override
            public String getAllProperties() {
                return "event,name,displayName,created,lastUpdated,access," +
                        "program,programStage,status,orgUnit,eventDate,dueDate," +
                        "coordinate,dataValues";
            }

            @Override
            public Call<Map<String, List<Event>>> getEntities(
                    Map<String, String> queryMap, List<String> filters) throws ApiException {
                return eventApiclientRetrofit.getEvents(queryMap, filters);
            }
        };

        return getCollection(apiResource, fields, lastUpdated, uids);
    }

    @Override
    public ApiResponse postEvents(List<Event> events) throws ApiException {
        return call(eventApiclientRetrofit.postEvents(events));
    }

    @Override
    public ApiResponse deleteEvent(Event event) throws ApiException {
        return call(eventApiclientRetrofit.deleteEvent(event.getUId()));
    }
}
