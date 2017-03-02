package edu.softserve.zoo.controller.rest;

import edu.softserve.zoo.dto.EmployeeDto;
import edu.softserve.zoo.dto.TaskStatisticsDto;
import edu.softserve.zoo.dto.TaskStatusDto;
import edu.softserve.zoo.dto.TaskTypeDto;
import edu.softserve.zoo.model.Employee;
import edu.softserve.zoo.model.TaskStatistics;
import edu.softserve.zoo.service.EmployeeService;
import edu.softserve.zoo.service.Service;
import edu.softserve.zoo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static edu.softserve.zoo.controller.rest.Routes.EMPLOYEES;

/**
 * Employee REST controller
 *
 * @author Julia Siroshtan
 */
@RestController
@RequestMapping(EMPLOYEES)
public class EmployeeRestController extends AbstractRestController<EmployeeDto, Employee> {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    @Override
    protected Service<Employee> getService() {
        return employeeService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @Override
    public EmployeeDto getById(@PathVariable Long id) {
        return super.getById(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    @Override
    public EmployeeDto create(@RequestBody EmployeeDto dto) {
        return super.create(dto);
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.PUT})
    @Override
    public EmployeeDto update(@Valid @RequestBody EmployeeDto dto, @PathVariable Long id) {
        return super.update(dto, id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @Override
    public ResponseEntity delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @RequestMapping(path = "/{id}/performance", method = RequestMethod.GET, produces = "application/json")
    public TaskStatisticsDto getStatistics(@PathVariable Long id) {
        TaskStatisticsDto dto = new TaskStatisticsDto();
        TaskStatistics statistics = taskService.getStatistics(id);
        dto.setTaskStatuses(
                statistics.getTaskStatuses().entrySet().stream()
                        .map(pair -> new TaskStatusDto(pair.getKey(), pair.getValue()))
                        .collect(Collectors.toList())
        );
        dto.setTaskTypes(
                statistics.getTaskTypes().entrySet().stream()
                        .map(pair -> new TaskTypeDto(pair.getKey(), pair.getValue()))
                        .collect(Collectors.toList())
        );
        return dto;
    }

    @RequestMapping(path = "/count", method = RequestMethod.GET)
    @Override
    public Long count() {
        return super.count();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeDto> getAll() {
        return super.getAll();
    }
}
