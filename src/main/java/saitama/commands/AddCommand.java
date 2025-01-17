package saitama.commands;

import saitama.storage.Storage;
import saitama.tasks.Task;
import saitama.tasks.TaskList;
import saitama.ui.Ui;


/**
 * A Command object that adds a task to the task list.
 */
public class AddCommand extends Command {
    private Task task;

    /**
     * Initialises the AddCommand.
     *
     * @param task The Task to add
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.add(task);
        storage.save(taskList.toArrayList());
        return ui.showAddTask(task, taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

