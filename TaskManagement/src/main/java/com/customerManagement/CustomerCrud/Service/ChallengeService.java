package com.customerManagement.CustomerCrud.Service;

import com.customerManagement.CustomerCrud.Entity.Challenge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ChallengeService {

    public String save(Challenge challenge);

    public List<Challenge> getAll();

    public Challenge getById(Long id);
    public Challenge getByMonth(String month);

    public Challenge update(Long id, Challenge challenge);

    public String delete(Long id);


}
