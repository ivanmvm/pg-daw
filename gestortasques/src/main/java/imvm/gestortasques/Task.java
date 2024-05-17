package imvm.gestortasques;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Date dueDate;
    private String status;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Task(String title, String description, Date dueDate, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return title + "," + description + "," + dateFormat.format(dueDate) + "," + status;
    }

    public static Task fromString(String taskString) throws Exception {
        String[] parts = taskString.split(",");
        if (parts.length != 4) {
            throw new Exception("Format de tasca incorrecte");
        }
        String title = parts[0];
        String description = parts[1];
        Date dueDate = dateFormat.parse(parts[2]);
        String status = parts[3];
        return new Task(title, description, dueDate, status);
    }
}
