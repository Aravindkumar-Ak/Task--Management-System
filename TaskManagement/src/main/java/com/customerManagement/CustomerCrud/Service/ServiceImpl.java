package com.customerManagement.CustomerCrud.Service;

import com.customerManagement.CustomerCrud.Entity.Challenge;
import com.customerManagement.CustomerCrud.Exception.ChallengeNotFound;
import com.customerManagement.CustomerCrud.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements ChallengeService{
    @Autowired
    private Repository repo;

    @Override
    public String save(Challenge challenge) {
        if(challenge!=null) {
            repo.save(challenge);
            return "Successfully saved";
        }
        return null;
    }

    @Override
    public List<Challenge> getAll() {
        return repo.findAll();
    }

    @Override
    public Challenge getById(Long id) {
       Optional<Challenge> findById= repo.findById(id);
        return findById.orElse(null);
    }

    @Override
    public Challenge getByMonth(String month) {
        Optional<Challenge> findById=repo.findByMonthIgnoreCase(month);
        if(findById.isPresent()) {
            return repo.findByMonthIgnoreCase(month).get();
        }
        return null;
    }

    @Override
    public Challenge update(Long id, Challenge challenge) {
        return repo.findById(id)
                .map(updatedChallenge -> {
                    updatedChallenge.setMonth(challenge.getMonth());
                    updatedChallenge.setChallenge(challenge.getChallenge());
                    return repo.save(challenge);
                }).orElseThrow(()->new ChallengeNotFound(id));
    }




    @Override
    public String delete(Long id) {
        Optional<Challenge> findById=repo.findById(id);
        if(findById.isPresent()){
            repo.deleteById(id);
            return "Deleted successfully";
        }
        return "Not deleted";
    }
}
