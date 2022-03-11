package com.sda.onlinestoreserver.controller;
import com.sda.onlinestoreserver.models.ContactMethod;
import com.sda.onlinestoreserver.repository.ContactMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contact_method")
public class ContactMethodController {

    @Autowired
    private ContactMethodRepository contactMethodRepository;

    @GetMapping("/get_by_id/{id}")
    public ContactMethod getById(@PathVariable("id") long id) {
        return contactMethodRepository.findById(id);
    }

    @GetMapping("/all")
    public List<ContactMethod> getAll() {
        return contactMethodRepository.findAll();
    }

    @PostMapping("/update")
    public void updateContactMethod(@RequestBody ContactMethod contactMethod) {
        contactMethodRepository.save(contactMethod);
    }

    @GetMapping("/delete/{id}")
    public void deleteContactMethod(@PathVariable("id") long id) {
        contactMethodRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveContactMethod(@RequestBody ContactMethod contactMethod) {
        contactMethodRepository.save(contactMethod);
    }
}
