package it.univaq.todo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.todo.model.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/todos")
public interface TodoRestApi {

    @Operation(
        description = "Returns the list of all Todo tasks",
        responses = {
            @ApiResponse(
                description = "Successful response with a list of Todo objects",
                content = {
                    @Content(
                        mediaType = MediaType.TEXT_XML,
                        array = @ArraySchema(schema = @Schema(implementation = Todo.class))
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_XML,
                        array = @ArraySchema(schema = @Schema(implementation = Todo.class))
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        array = @ArraySchema(schema = @Schema(implementation = Todo.class))
                    )
                }
            )
        }
    )
    
    @GET
    @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Todo> getTodos();
    
    @Operation(
    	    description = "Retrieve a single Todo item by its ID",
    	    responses = {
    	        @ApiResponse(
    	            description = "Todo item found",
    	            content = @Content(
    	                mediaType = MediaType.APPLICATION_JSON,
    	                schema = @Schema(implementation = Todo.class)
    	            )
    	        )
    	    }
    	)
    	@GET
    	@Path("/{id}")
    	public Todo getTodo(@PathParam("id") String id);
    
    @Operation(
    	    description = "Creates a new Todo item",
    	    responses = {
    	        @ApiResponse(
    	            description = "Boolean response indicating success",
    	            content = @Content(
    	                mediaType = MediaType.APPLICATION_JSON,
    	                schema = @Schema(implementation = Boolean.class)
    	            )
    	        )
    	    }
    	)
    	@POST
    	public boolean create(
    	    @RequestBody(
    	        description = "Todo item to be created",
    	        required = true,
    	        content = {
    	            @Content(
    	                mediaType = MediaType.APPLICATION_XML,
    	                schema = @Schema(implementation = Todo.class)
    	            ),
    	            @Content(
    	                mediaType = MediaType.APPLICATION_JSON,
    	                schema = @Schema(implementation = Todo.class)
    	            )
    	        }
    	    ) Todo todo
    	);

    @Operation(
    	    description = "Update an existing Todo item",
    	    responses = {
    	        @ApiResponse(
    	            description = "Returns true if the update was successful",
    	            content = @Content(
    	                mediaType = MediaType.APPLICATION_JSON,
    	                schema = @Schema(implementation = Boolean.class)
    	            )
    	        )
    	    }
    	)
    	@PUT
    	@Consumes(MediaType.APPLICATION_JSON)
    	public boolean update(
    	    @RequestBody(
    	        description = "The Todo object with updated fields",
    	        required = true,
    	        content = @Content(
    	            mediaType = MediaType.APPLICATION_JSON,
    	            schema = @Schema(implementation = Todo.class)
    	        )
    	    ) Todo todo
    	);


    	@Operation(
    	    description = "Delete a Todo item by ID",
    	    responses = {
    	        @ApiResponse(
    	            description = "Returns true if the deletion was successful",
    	            content = @Content(
    	                mediaType = MediaType.APPLICATION_JSON,
    	                schema = @Schema(implementation = Boolean.class)
    	            )
    	        )
    	    }
    	)
    	@DELETE
    	@Path("/{id}")
    	public boolean delete(@PathParam("id") String id);


}
