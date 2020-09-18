package ua.com.alevel.ionio.serializable;

import lombok.*;

import java.io.Serializable;

/**
 * @author Iehor Funtusov, created 24/07/2020 - 7:08 PM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable {

    private transient int number;
}
