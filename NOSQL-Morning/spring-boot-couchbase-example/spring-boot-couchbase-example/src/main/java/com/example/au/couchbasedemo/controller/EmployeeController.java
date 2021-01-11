package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }
    
    @GetMapping("/employee/{empId}")
    public Optional<Employee> getEmployee(@PathVariable String empId) {
        if (employeeRepository.existsById(empId)) {
            return employeeRepository.findById(empId);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/employee/address/{address}")
    public Employee getEmployeeByAddress(@PathVariable String address) {
        return employeeRepository.findByAddress(address);
    }
    
//    @DeleteMapping("/blogs/topic/{topic}/author/{author}")
//    public List<Blogs> deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
//        return blogRepository.deleteBytopicAndAuthor(topic, author);
//    }
    
    @DeleteMapping("/employee/{empId}")
    public void deleteById(@PathVariable String empId) {
        employeeRepository.deleteById(empId);
    }
    
	/*
	 * @PutMapping("/blogs/{idToBeUpdated}") public String updateBlog(@PathVariable
	 * String idToBeUpdated, @RequestBody BlogsUpdateRequest blogsUpdateRequest) {
	 * 
	 * Optional<Blogs> mayBeBlog = blogRepository.findById(idToBeUpdated) .map(blogs
	 * –> blogRepository .save(Blogs .builder() .id(idToBeUpdated)
	 * .topic(blogsUpdateRequest.getTopic()) .tags(blogsUpdateRequest.getTags())
	 * .author(blogs.getAuthor()) .date(blogs.getDate()) .build()) ); if
	 * (mayBeBlog.isPresent()) { return "Blog Updated"; } else { return
	 * "Blog does not exist"; } }
	 */
}