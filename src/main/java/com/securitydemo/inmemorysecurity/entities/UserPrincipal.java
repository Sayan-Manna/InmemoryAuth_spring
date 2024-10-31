//package com.securitydemo.inmemorysecurity.entities;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserPrincipal implements UserDetails {
//    private User user;
//
//    public UserPrincipal(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
////        return Collections.singleton(new SimpleGrantedAuthority(user.getRoles().forEach(role->);));
//        return user.getRoles().stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toSet());
//
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
////        return UserDetails.super.isAccountNonExpired();
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
////        return UserDetails.super.isAccountNonLocked();
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
////        return UserDetails.super.isCredentialsNonExpired();
//        return true;
//    }
//
//
//    @Override
//    public boolean isEnabled() {
////        return UserDetails.super.isEnabled();
//        return true;
//    }
//}