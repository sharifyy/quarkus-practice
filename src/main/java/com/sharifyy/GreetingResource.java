package com.sharifyy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Objects;

@Path("/frameworks")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Framework> getFrameworks() {
        return List.of(
                new Framework("Quarkus", List.of("Java", "Kotlin")),
                new Framework("Spring", List.of("Java", "Kotlin", "Groovy")),
                new Framework("Micronaut", List.of("Java", "Kotlin", "Groovy","Scala"))
        );
    }
}

