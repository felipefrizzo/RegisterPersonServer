package br.univel.model;

import br.univel.enums.OperationType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by felipefrizzo on 10/11/16.
 */
@Entity
@Table(name = "professional")
public class Professional implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password", unique = true)
    private String password;
    @Transient
    private OperationType operationType;

    /**
     * Initializes a newly created instance of this type without specific arguments.
     */
    public Professional() {
    }

    /**
     * Initializes a newly created instance of this type with specific arguments.
     *
     * @param name
     * @param birthday
     * @param username
     * @param password
     * @param operationType
     */
    public Professional(final String name, final Date birthday, final String username, final String password, final OperationType operationType) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(birthday, "Birthday cannot be null");
        Objects.requireNonNull(username, "Cpf cannot be null");
        Objects.requireNonNull(password, "Rg cannot be null");

        this.name = name;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.operationType = operationType;
    }

    /**
     *
     * @return The current value of this Professional's ID
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id New Value for this Professional's Id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     *
     * @return The current value of this Professional's Name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name New Value for this Professional's Name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return The current value of this Professional's Birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday New Value for this Professional's Birthday
     */
    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @return The current value of this Professional's Username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username New Value for this Professional's Username.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     *
     * @return The current value of this Professional's Password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password New Value for this Professional's Password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     *
     * @return The current value of this Customer's Operation Type
     */
    public OperationType getOperationType() {
        return operationType;
    }

    /**
     *
     * @param operationType New Value for this Customer's Operation Type
     */
    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
