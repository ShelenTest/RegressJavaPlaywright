package org.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Route;
import org.utils.objectsSerialization.BodyResponse;

public class RequestInterception {
    private BodyResponse bodyResponse;
    private ObjectMapper objectMapper;

    public RequestInterception() {
        this.bodyResponse = new BodyResponse(false, "Test error message", "INTERNAL_ERROR", null);
        this.objectMapper = new ObjectMapper();
    }

    public void mock500(Page page, String path) throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(bodyResponse);

        // Настройка пути перехвата
        page.route(path, route -> {
            route.fulfill(new Route.FulfillOptions()
                    .setStatus(500)
                    .setContentType("application/json")
                    .setBody(jsonString));
        });
    }
}


