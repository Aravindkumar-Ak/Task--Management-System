package com.customerManagement.CustomerCrud.Controller;

import com.customerManagement.CustomerCrud.Entity.Challenge;
import com.customerManagement.CustomerCrud.Service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/challenge")
@CrossOrigin(origins = "http://localhost:5173/")
public class ChallengeController {
@Autowired
    private ServiceImpl service;

@PostMapping("/challenge")
    public ResponseEntity<String> saveChallenge(@RequestBody Challenge challenge)
  {
        String status=service.save(challenge);
        return new ResponseEntity<>(status,HttpStatus.CREATED);
    }

 @GetMapping("/getAllChallenges")
 public ResponseEntity<List<Challenge>> getChallenges()
 {
   List<Challenge> listOfChallenges=service.getAll();
   return new ResponseEntity<>(listOfChallenges,HttpStatus.OK);
 }
 @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> GetByMonth(@PathVariable String month)
 {
    Challenge challenge=service.getByMonth(month);
    return new ResponseEntity<>(challenge,HttpStatus.OK);
 }
    @GetMapping("/getChallenge/{id}")
    public ResponseEntity<Challenge> GetById(@PathVariable Long id)
    {
        Challenge challenge=service.getById(id);
        return new ResponseEntity<>(challenge,HttpStatus.OK);
    }

 @PutMapping("/challenges/{id}")
    public ResponseEntity<Challenge> updateChallenge(@PathVariable Long id,@RequestBody Challenge challenge)
 {
    Challenge updated=service.update(id,challenge);
    return new ResponseEntity<>(updated,HttpStatus.CREATED);
 }
 @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id)
 {
    String status=service.delete(id);
    return new ResponseEntity<>(status,HttpStatus.OK);
 }
}
