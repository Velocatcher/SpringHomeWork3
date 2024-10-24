package com.example.seminar3HomeTask.controllers;

import com.example.seminar3HomeTask.domain.User;
import com.example.seminar3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort") //localhost:8080/tasks/sort
    public List<User> sortUserByAge(){

        return service.sortUsersByAge(service.getRepository().getUsers());
    }

//    filterUsersByAge @GetMapping("/filter{age}")
@GetMapping("/filter/{age}") //localhost:8080/tasks/filter/23
public List<User> filterUsersByAge(@PathVariable("age") int age){

    return service.filterUserByAge(service.getRepository().getUsers(), age);

}
//    calculateAverageAge @GetMapping("/calk")
//    Средний возраст
@GetMapping("/calc")
public Double calculateAverageAge(){

    return service.calculateAverageAge(service.getRepository().getUsers());

}

}
