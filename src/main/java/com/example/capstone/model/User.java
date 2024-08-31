package com.example.capstone.model;


import jakarta.persistence.*;

import java.util.Collection;
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinTable(
    //        name = "user",
//            joinColumns = @JoinColumn(
//                    name = "id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "email", referencedColumnName = "id"))
//    private Collection<Role> roles;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

//    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        //this.roles = roles;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    //public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + "*********" + '\'' +
                // ", roles=" + roles +
                '}';
    }

}









//import lombok.Setter;
//import lombok.Getter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.Collection;
//import java.util.Set;
//import com.example.capstone.model.Role;
//
//
///**
// * Entity class representing a user in the system.
// */
//@Entity
//@Getter
//@Setter
//@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "first_name", nullable = false)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false)
//    private String lastName;
//
//    @Column(name = "email", nullable = false, unique = true)
//    private String email;
//
//    @Column(name = "username", nullable = false, unique = true)
//    private String username;
//
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @Column(name = "enabled", nullable = false)
//    private boolean enabled = true;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Booking> bookings;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Review> reviews;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    // Getters and setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public Set<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(Set<Booking> bookings) {
//        this.bookings = bookings;
//    }
//
//    public Set<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(Set<Review> reviews) {
//        this.reviews = reviews;
//    }
//}




///**   FIRST DRAFT   ///////
// * Entity class representing a user in the system.
// */
//@Entity
//@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "first_name", nullable = false)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false)
//    private String lastName;
//
//    @Column(name = "email", nullable = false)
//    private String email;
//
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Booking> bookings;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Review> reviews;
//
//    // Implement UserDetails methods
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    // Getters and setters
//}