package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

/**
 * Todo object that represents a task with ID, summary and description.
 */
@Schema(description = "Todo object that represents a task with ID, summary and description.")
@XmlRootElement(name = "Todo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Todo {

    @Schema(example = "1", description = "Unique identifier of the task")
    @JsonProperty("id")
    private Long id;

    @Schema(example = "Finish Swagger integration", description = "Short summary of the task")
    @JsonProperty("summary")
    private String summary;

    @Schema(example = "Complete the integration of Swagger UI and OpenAPI with CXF", description = "Detailed task description")
    @JsonProperty("description")
    private String description;

    public Todo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Todo id(Long id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Todo summary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Todo description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Todo {\n" +
                "    id: " + id + "\n" +
                "    summary: " + summary + "\n" +
                "    description: " + description + "\n" +
                "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;
        return id != null && id.equals(todo.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    

}
