package com.example.airpot.services;

import java.security.Principal;
import java.util.List;

import com.example.airpot.models.User;
import com.example.airpot.repositories.AirportRepository;
import com.example.airpot.models.airport1;
import com.example.airpot.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {

    @Autowired
    private AirportRepository repo;

    private final UserRepository userRepository;

    public List<airport1> listAll(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            List<airport1> airports = repo.search(keyword);
            System.out.println("Found airports: " + airports);
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void save(airport1 airport1) {
        repo.save(airport1);
    }

    public airport1 get(Long AirportID) {
        return repo.findById(AirportID).orElse(null);
    }

    public void delete(Long AirportID) {
        repo.deleteById(AirportID);
    }
}
