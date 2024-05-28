package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.exceptions.AppException;
import com.GroupD.FurnishUp.repository.FurnishUpRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class FurnishUpServiceImpl implements FurnishUpService{

    @Autowired
    private FurnishUpRepo furnishUpRepo;

    @Override
    public List<Users> getAllUsers() {
        return furnishUpRepo.findAll();}

    public Users saveUsers(Users users) {
        this.furnishUpRepo.save(users);
        return users;
    }

    public Users getUsersById(Long id) {
        Optional<Users> optional = furnishUpRepo.findById(id);
        Users users;
        if(optional.isPresent()) {
            users = optional.get();
        }else { throw new AppException("User not Found", HttpStatus.NOT_FOUND);}
        return users;
    }

//    @Override
//    public void softDeleteUsers(Long id) {
//        Optional<Users> usersOptional = furnishUpRepo.findById(id);
//        if(usersOptional.isPresent()){
//            Users users = usersOptional.get();
//            users.setDeleted(true);
//            furnishUpRepo.save(users);
//        }else {
//            throw new EntityNotFoundException("Not Found");
//        }
//    }

    @Override
    public Users updateUsers(Long id, Users users) {
        Users userFromDB = furnishUpRepo.findById(id).get();
        userFromDB.setUsername(users.getUsername());
        userFromDB.setEmail(users.getEmail());
        userFromDB.setPassword(users.getPassword());
        furnishUpRepo.save(userFromDB);
        return userFromDB;
    }

     @Override
 public Users deleteUsers(Long id) {furnishUpRepo.deleteById(id);
         return null;
     }
}
