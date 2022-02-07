import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import saitama.tasks.Task;
import saitama.tasks.ToDo;

class ToDoTest {

    private Task task = new ToDo("Eat", null);

    @Test
    void testToString() {
        assertEquals("[T][ ] Eat", task.toString());
        task.markAsDone();
        assertEquals("[T][X] Eat", task.toString());
    }
}
