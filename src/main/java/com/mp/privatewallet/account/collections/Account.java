package com.mp.privatewallet.account.collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Account {

    @Id
    public String id;

    @Indexed(unique = true)
    public String ownerName;

    public Account(final String ownerName) {
        this.id = id;
        this.ownerName = ownerName;
    }

}
