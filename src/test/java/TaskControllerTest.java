import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskRepo taskRepo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = ValidationException.class)
    public void naoDeveSalvarTarefaSemDescricao() throws ValidationException {
        //cenario
        Task todo = new Task();
        todo.setDueDate(LocalDate.now());
        //acao
        taskController.save(todo);
        //verificacao
    }

    @Test(expected = ValidationException.class)
    public void naoDeveSalvarUmaTarefaSemData() throws ValidationException {
        //cenario
        Task todo = new Task();
        todo.setTask("tarefa 1");
        //acao
        taskController.save(todo);
        //verificacao
    }

    @Test(expected = ValidationException.class)
    public void naoDeveSalvarUmaTarefaComDataPassada() throws ValidationException {
        //cenario
        Task todo = new Task();
        todo.setTask("tarefa 1");
        todo.setDueDate(LocalDate.of(2010, 1, 1));
        //acao
        taskController.save(todo);
        //verificacao
    }

    @Test
    public void deveSalvarUmaTarefa() throws ValidationException {
        //cenario
        Task todo = new Task();
        todo.setTask("tarefa 1");
        todo.setDueDate(LocalDate.now());
        //acao
        taskController.save(todo);
        //verificacao
        Mockito.verify(taskRepo).save(todo);
    }

}
