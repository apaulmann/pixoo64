package de.paulmannit.client;

import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "pixoo-api")
@Path("/post")
public interface PixooClient {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    String reboot(JsonObject body);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    String post(String body);

}
