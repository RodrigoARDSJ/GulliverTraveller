package br.com.fiap.traveller.models;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuario")
    private Integer id;

    @Column(name = "nm_usuario", nullable = false, length = 60)
    private String name;

    @Column(name = "ds_email", nullable = false, length = 60)
    private String email;

    @Column(name = "nr_cpf", nullable = false, length = 16)
    private String cpf;

    @Column(name = "ds_senha", nullable = false, length = 16)
    private String password;

    public User() {
    }

    public User(String name, String email, String cpf, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    public User(Integer id, String name, String email, String cpf, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}