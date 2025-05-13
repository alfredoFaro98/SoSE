package it.univaq.todo.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Todo object that represents a task with ID, summary and description.")
public class Todo {

    @Schema(description = "Unique identifier of the task", example = "1")
    private Long id;

    @Schema(description = "Short summary of the task", example = "Finish Swagger integration")
    private String summary;

    @Schema(description = "Detailed task description", example = "Complete the integration of Swagger UI and OpenAPI with CXF")
    private String description;

    public Todo() {
    }

    public Todo(Long id) {
        this.id = id;
    }

    public Todo(Long id, String summary, String description) {
        this.id = id;
        this.summary = summary;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
