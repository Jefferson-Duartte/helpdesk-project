package com.jefferson.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jefferson.helpdesk.domain.enums.PROFILE;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "document"})
@Entity(name = "tb_person")
public abstract class Person implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String name;

    @Column(unique = true)
    protected String document;

    @Column(unique = true)
    protected String email;

    protected String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_profiles")
    protected Set<PROFILE> profiles = EnumSet.noneOf(PROFILE.class);

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    public Person() {
        addProfiles(PROFILE.CLIENT);
    }

    public Person(Integer id, String name, String document, String email, String password) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
    }

    public void addProfiles(PROFILE profile) {
        if (profile != null) {
            this.profiles.add(profile);
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
