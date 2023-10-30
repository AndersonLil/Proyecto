package com.ecommerce.rbt.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class User {

    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String Numero_cell;
    private String email;
    private Date Fecha_Nac;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

    // Getters y setters para los nuevos campos
    public String getNumero_cell() {
        return Numero_cell;
    }

    public void setNumero_cell(String phoneNumber) {
        this.Numero_cell = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_Nac() {
        return Fecha_Nac;
    }

    public void setFecha_Nac(Date dateOfBirth) {
        this.Fecha_Nac = dateOfBirth;
    }

    // Resto de los getters y setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
