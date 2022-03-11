package com.sda.onlinestoreserver.controller;
import com.sda.onlinestoreserver.models.Role;
import com.sda.onlinestoreserver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/get_by_id/{id}")
    public Role getById(@PathVariable("id") long id) {
        return roleRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @PostMapping("/update")
    public void updateRole(@RequestBody Role role) {
        roleRepository.save(role);
    }

    @GetMapping("/delete/{id}")
    public void deleteRole(@PathVariable("id") long id) {
        roleRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveRole(@RequestBody Role role) {
        roleRepository.save(role);
    }
}
