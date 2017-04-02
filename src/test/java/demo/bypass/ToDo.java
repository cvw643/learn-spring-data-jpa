package demo.bypass;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YQ.Huang
 */
@Entity
public class ToDo {
    @Id
    private int id;

    private String title;

    private boolean completed;

    ToDo() {
    }

    public ToDo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDo toDo = (ToDo) o;

        return id == toDo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
