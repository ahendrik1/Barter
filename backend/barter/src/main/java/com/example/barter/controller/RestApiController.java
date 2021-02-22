package com.example.barter.controller;

import com.example.barter.model.Interest;
import com.example.barter.model.Product;
import com.example.barter.model.Success;
import com.example.barter.model.User;
import com.example.barter.repository.InterestRepository;
import com.example.barter.repository.ProductRepository;
import com.example.barter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RestApiController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    InterestRepository interestRepository;

    /*
    User APIs
     */

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable(value="id") int id) {
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable(value="id") int id, @RequestBody User userDetails) {
        Optional<User> user = userRepository.findById(id);
        User user_new = user.get();
        user_new.setName(userDetails.getName());
        user_new.setPassword(userDetails.getPassword());
        return userRepository.save(user_new);

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable(value="id") int id) {
        Optional<User> user = userRepository.findById(id);
        User user_new = user.get();
        userRepository.delete(user_new);
    }

    @PostMapping("/user/login")
    public Success login(@RequestBody User userDetails) {
        Optional<User> user = userRepository.findByName(userDetails.getName());
        Success success;
        if(!user.isEmpty()) {
            User user_temp = user.get();
            if(userDetails.getName().equals(user_temp.getName()) && userDetails.getPassword().equals(user_temp.getPassword())) {
                success = new Success(1, "Login Successful");
            } else {
                success = new Success(2, "Wrong username or password");
            }
        } else {
            success = new Success(2, "User not found");
        }
        return success;
    }

    /*
    Product APIs
     */


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable(value="id") int id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }


    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable(value="id") int id, @RequestBody Product productDetails) {
        Optional<Product> product = productRepository.findById(id);
        Product product_new = product.get();
        product_new.setName(productDetails.getName());
        product_new.setDescription(productDetails.getDescription());
        product_new.setAge(productDetails.getAge());
        product_new.setBrand(productDetails.getBrand());
        product_new.setColor(productDetails.getColor());
        return productRepository.save(product_new);

    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable(value="id") int id) {
        Optional<Product> product = productRepository.findById(id);
        Product product_new = product.get();
        productRepository.delete(product_new);
    }

    /*
    Interest APIs
     */


    @GetMapping("/interests")
    public List<Interest> getAllInterests() {
        return interestRepository.findAll();
    }

    @GetMapping("/interest/{id}")
    public Optional<Interest> getInterest(@PathVariable(value="id") int id) {
        return interestRepository.findById(id);
    }

    @PostMapping("/interest")
    public Interest addInterest(@RequestBody Interest interest) {
        return interestRepository.save(interest);
    }


    @PutMapping("/interest/{id}")
    public Interest updateInterest(@PathVariable(value="id") int id, @RequestBody Interest interestDetails) {
        Optional<Interest> interest = interestRepository.findById(id);
        Interest interest_new = interest.get();
        interest_new.setInterested_uid(interestDetails.getInterested_uid());
        interest_new.setOffering_pid(interestDetails.getOffering_pid());
        interest_new.setPid(interestDetails.getPid());
        return interestRepository.save(interest_new);

    }

    @DeleteMapping("/interest/{id}")
    public void deleteInterest(@PathVariable(value="id") int id) {
        Optional<Interest> interest = interestRepository.findById(id);
        Interest interest_new = interest.get();
        interestRepository.delete(interest_new);
    }
}
