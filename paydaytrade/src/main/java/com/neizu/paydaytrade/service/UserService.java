package com.neizu.paydaytrade.service;
import com.neizu.paydaytrade.dto.UserAccountDto;
import com.neizu.paydaytrade.dto.request.CreateUserRequest;
import com.neizu.paydaytrade.dto.request.UpdateUserDto;
import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.exception.UserNotFoundException;
import com.neizu.paydaytrade.exception.UsernameAlreadyDefinedException;
import com.neizu.paydaytrade.exception.UsernameNotFoundException;
import com.neizu.paydaytrade.repository.UserRepo;
import com.neizu.paydaytrade.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserConverter userConverter;




    public void createUser(CreateUserRequest createUserRequest) {
        Optional<User> userOptional = userRepo.findUserByUsername(createUserRequest.getUsername());
        if (userOptional.isPresent()) {
            throw new UsernameAlreadyDefinedException("This Username-"
                    + createUserRequest.getUsername() + "-is present");
        } else {
            User user = User.builder()
                    .username(createUserRequest.getUsername())
                    .email(createUserRequest.getEmail())
                    .name(createUserRequest.getName())
                    .build();
            userRepo.save(user);
        }
    }

    public List<UserAccountDto> getAllUser() {
        return userRepo.findAll()
                .stream()
                .map(userConverter::converterUserAccount).collect(Collectors.toList());
    }

    public UserAccountDto getUserById(Integer id) {
        User user = findById(id);
        return userConverter.converterUserAccount(user);
    }

    public UserAccountDto findUserByEmail(String username) {
        Optional<User> optionalUser = userRepo.findUserByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(username + "-This username is NotFound:::");
        }
        return userConverter.converterUserAccount(optionalUser.get());
    }

    public UserAccountDto updateUser(Integer id, UpdateUserDto updateDto) {
        User user=findById(id);
        user.setName(updateDto.getName());
        user.setEmail(updateDto.getEmail());
        userRepo.save(user);
       return userConverter.converterUserAccount(user);
    }

    public User findById(Integer id) {
        Optional<User>userOptional=userRepo.findById(id);
        if (userOptional.isEmpty()){
            throw new UserNotFoundException
                    (id + "-is userId NotFound");
        }else {
            return userOptional.get();
        }
    }










}

























