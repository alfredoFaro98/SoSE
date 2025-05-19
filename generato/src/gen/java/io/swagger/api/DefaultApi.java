package io.swagger.api;

import io.swagger.model.Todo;
import java.util.List;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface DefaultApi {

    @POST
    @Operation(summary = "Create a new Todo")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Creation successful",
            content = @Content(schema = @Schema(implementation = Boolean.class)))
    })
    Boolean create1(Todo body);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a Todo by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Deletion successful",
            content = @Content(schema = @Schema(implementation = Boolean.class)))
    })
    Boolean delete1(@PathParam("id") String id);

    @GET
    @Path("/{id}")
    @Operation(summary = "Get a Todo by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Todo found",
            content = @Content(schema = @Schema(implementation = Todo.class)))
    })
    Todo getTodo1(@PathParam("id") String id);

    @GET
    @Operation(summary = "Get all Todos")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "List of Todos",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Todo.class))))
    })
    List<Todo> getTodos1();

    @PUT
    @Operation(summary = "Update a Todo")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Update successful",
            content = @Content(schema = @Schema(implementation = Boolean.class)))
    })
    Boolean update1(Todo body);
}
