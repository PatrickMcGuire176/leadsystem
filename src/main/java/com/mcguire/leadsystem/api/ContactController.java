package com.mcguire.leadsystem.api;

import com.mcguire.leadsystem.model.Contact;
import com.mcguire.leadsystem.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/contact")
@RestController
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public void addContact(@NonNull @RequestBody Contact contact){
        contactService.addContact(contact);
    }

    @GetMapping
    public List<Contact> getAllPeople(){
        return contactService.getAllContacts();
    }

    @GetMapping(path="{id}")
    public Contact getContactById(@PathVariable("id") Long id){
        return contactService.getContactByID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteContactById(@PathVariable("id") Long id){
        contactService.deleteContact(id);
    }

    @PutMapping(path = "{id}")
    public void updateContact(@PathVariable("id") Long id, @NonNull @RequestBody Contact contactToUpdate){
        contactService.updateContact(id,contactToUpdate);
    }
}