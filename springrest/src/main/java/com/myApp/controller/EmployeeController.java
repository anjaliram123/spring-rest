package com.myApp.controller;

import com.myApp.entity.Employee;
import com.myApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//for both controller and responsebody together we have restController
//@Controller
//@ResponseBody
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping(method= RequestMethod.GET, value="/employees")
    public List<Employee>findAll()
    {
          return service.findAll();
    }
    @RequestMapping(method=RequestMethod.GET, value="/employees/{id}")
    public Employee findOne(@PathVariable("id") String id)
    {
        return service.findOne(id);
    }
    @RequestMapping(method=RequestMethod.POST, value="/employees")
    public Employee create(@RequestBody Employee emp)
    {
          return service.create(emp);
    }
    @RequestMapping(method=RequestMethod.PUT,value="/employees/{id}" )
    public Employee  update(String id, @RequestBody Employee emp)
    {
        return service.update(id,emp);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/employee/{id}")
    public void delete(@PathVariable("id") String id)
    {
               service.delete(id);
    }
}
