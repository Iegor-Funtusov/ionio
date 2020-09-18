package ua.com.alevel.ionio.serializable;

import lombok.*;

import java.io.Serializable;

/**
 * @author Iehor Funtusov, created 24/07/2020 - 7:10 PM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private String name;
    private Group group;
}
