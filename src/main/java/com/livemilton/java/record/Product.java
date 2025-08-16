package com.livemilton.java.record;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public final class Product {

    private final String name;
    private final double price;
}
