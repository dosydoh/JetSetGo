package com.example.capstone.controllers;


import com.example.capstone.model.User;
import com.example.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.getUserById(id).isPresent()) {
            user.setId(id);  // Ensure that the ID is set correctly
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);  // Return the updated user
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


//FIRST DRAFT////



//import org.springframework.web.servlet.ModelAndView;

//import com.example.capstone.dto.UserRegistrationDto;
//import com.example.capstone.model.User;
//import com.example.capstone.services.UserService;
//
//
///**
// * Controller class for handling User related web requests.
// */
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public String listUsers(Model model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "users";
//    }
//
//    @GetMapping("/{id}")
//    public String getUser(@PathVariable Long id, Model model) {
//        User user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "user-details";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute UserRegistrationDto userRegistrationDto) {
//        userService.registerUser(userRegistrationDto);
//        return "redirect:/login";
//    }
//
//    @PutMapping("/{id}")
//    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
//        userService.updateUser(id, user);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
//}










//public class UserController {
 //   private UserService userService;

 //   public UserController(UserService userService){
 //       super();
 //       this.userService = userService;
 //   }


 //   @GetMapping("/account")
 //   public String listAccount(Model model){
  //      System.out.println("IN UserController->listAccount()");
 //       model.addAllAttributes("account", userService.getAll()); //fix.getA
 //       return "account";
 //   }

 //   @GetMapping("/account/new")
//    public String createUserForm(Model model){
 //       System.out.println("IN UserController->createUserForm()");
        //create user object to hold user form data
 //      customer_profile user = new customer_profile();
  //      model.addAttribute("customer_profile", customer_profile);
 //       return "create_user";
 //   }

 //   @PostMapping("/users)")
 //   public String saveUser(@ModelAttribute("customer_profile") customer_profile customer_profile) {
  //      System.out.println("IN UserController->saveUser()");
 //       userService.saveUser(user);
 //       return "redirect:/users";
 //   }

 //   @GetMapping("/users/edit/{id}")
 //   public String editUserForm(@PathVariable Long id, @ModelAttribute("user") User user,
 //                              Model model) {

        //get user from database by id
 //       User existingUser = userService.getUserById(id);
  //      existingUser.setId(id);
  //      existingUser.setFirstName(user.getFirstName());
  //      existingUser.setLastName(user.getLastName));
 //       existingUser.setEmail(user.getEmail));

    //save updated customer object
 //// return "redirect:/users";
 //   }

 //   //handler method handles delete
 //   @GetMapping("/users/{id}")
 //   public String deleteUser(@PathVariable Long id) {
 //       System.out.println("IN UserController->deleteUser()");
 //       userService.deleteUserById(id);
  //      return "redirect:/users";
  //  }
//}
