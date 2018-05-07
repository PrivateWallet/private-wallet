package com.mp.privatewallet.account.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;


@Data
@NoArgsConstructor
public class Account {

    @GeneratedValue
    public String id;

    @Id
    public String ownerName;

    public Account(String ownerName) {
        this.id = id;
        this.ownerName = ownerName;
    }

}
