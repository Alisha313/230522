package com.revature.controllers;

import com.revature.models.Course;
import com.revature.models.Person;
import com.revature.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class PersonController {

    //we need to inject in our PersonService

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //
    @GetMapping
    public List<Person> getAllPeopleHandler(){
        return personService.getAllPeople();
    }

    //
    @GetMapping("{id}") //
    public Person getPersonByIdHandler(@PathVariable("id") int id){
        return personService.getPersonById(id);
    }

    //
    //
    @PostMapping
    public Person createPersonHandler(@RequestBody Person p){
        return personService.createPerson(p);
    }

    //
    @PutMapping
    public Person updatePersonHandler(@RequestBody Person p){
        return personService.updatePerson(p);
    }

    //
    @DeleteMapping("{id}")
    public boolean deletePersonHandler(@PathVariable("id") int id){
        return personService.deletePersonById(id);
    }

    //
    @GetMapping("(id)/courses")
    public List<Course> getCoursesFromPersonHandler(@PathVariable("id") int id){
        return personService.getCourseByPersonId(id);
    }

    @PostMapping("{pid}/courses/register/{cid}")
    public Person registerForCourseHandler(@PathVariable("pid") int pid, @PathVariable("cid") int cid){
        return personService.registerForCourse(pid, cid);
    }

    @DeleteMapping("{pid}/courses/register/{cid}")
        public Person unregisterForCourseHandler(@PathVariable("pid") int pid, @PathVariable("cid") int cid){
            return personService.registerForCourse(pid, cid);
    }

}
