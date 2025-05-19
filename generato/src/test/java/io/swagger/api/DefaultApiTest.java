package io.swagger.api;

import io.swagger.model.Todo;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.MediaType;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultApiTest {

    private DefaultApi api;

    @BeforeEach
    public void setup() {
        JacksonJsonProvider provider = new JacksonJsonProvider();
        List<Object> providers = new ArrayList<>();
        providers.add(provider);

        api = JAXRSClientFactory.create(
            "http://localhost:8080/TodoRESTServiceOpenApiSwagger/rest",
            DefaultApi.class,
            providers
        );

        WebClient.client(api)
                 .type(MediaType.APPLICATION_JSON)
                 .accept(MediaType.APPLICATION_JSON);
    }

    @Test
    public void createTest() {
        Todo todo = new Todo()
            .id(123L)
            .summary("Create test")
            .description("Testing create endpoint");

        Boolean result = api.create1(todo);
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void getTodo1Test() {
        Todo response = api.getTodo1("123");
        assertNotNull(response);
        assertEquals(123L, response.getId());
    }

    @Test
    public void getTodos1Test() {
        List<Todo> list = api.getTodos1();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
    }

    @Test
    public void updateTest() {
        Todo updated = new Todo()
            .id(123L)
            .summary("Updated summary")
            .description("Updated via test");

        Boolean success = api.update1(updated);
        assertNotNull(success);
        assertTrue(success);
    }

    @Test
    public void deleteTest() {
        Boolean result = api.delete1("123");
        assertNotNull(result);
        assertTrue(result.booleanValue());
    }
}
