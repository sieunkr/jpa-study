package com.example.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "membership_card")
public class MembershipCard {
    @Id
    @Column(name = "card_number")
    private String number;

    //User 객체의 식별자에 해당하는 참조키로 user_email 을 지정, !!외래키
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    private User owner;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiry_date")
    private Date expiryDate;

    private boolean enabled;

    public MembershipCard() {
    }

    public MembershipCard(String number, User owner, Date expiryDate) {
        this.number = number;
        this.owner = owner;
        this.expiryDate = expiryDate;
        this.enabled = true;
    }

    public String getNumber() {
        return number;
    }

    public User getOwner() {
        return owner;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void assignTo(User owner) {
        if (this.owner != null)
            //throw new AlreadyAssignedCardException();
        this.owner = owner;
    }

    public void cacenAssignment() {
        this.owner = null;
    }

    public void disable() {
        this.enabled = false;
    }
}