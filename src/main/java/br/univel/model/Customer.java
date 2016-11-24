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
@Table(name = "client")
public class Customer implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "cpf", unique = true)
    private String cpf;
    @Column(name = "rg", unique = true)
    private String rg;
    @Transient
    private OperationType operationType;

    /**
     * Initializes a newly created instance of this type without specific arguments.
     */
    public Customer() {
    }

    /**
     * Initializes a newly created instance of this type with specific arguments.
     *
     * @param name
     * @param birthday
     * @param cpf
     * @param rg
     * @param operationType
     */
    public Customer(final String name, final Date birthday, final String cpf, final String rg, final OperationType operationType) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(birthday, "Birthday cannot be null");
        Objects.requireNonNull(cpf, "Cpf cannot be null");
        Objects.requireNonNull(rg, "Rg cannot be null");
        Objects.requireNonNull(operationType, "Operation Type cannot be null");

        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.rg = rg;
        this.operationType = operationType;
    }

    /**
     *
     * @return The current value of this Customer's Id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id New Value for this Customer's Id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     *
     * @return The current value of this Customer's Name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name New Value for this Customer's Name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return The current value of this Customer's Birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday New Value for this Customer's Birthday
     */
    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @return The current value of this Customer's Cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf New Value for this Customer's Cpf
     */
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return The current value of this Customer's Rg
     */
    public String getRg() {
        return rg;
    }

    /**
     *
     * @param rg New Value for this Customer's Rg
     */
    public void setRg(final String rg) {
        this.rg = rg;
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
