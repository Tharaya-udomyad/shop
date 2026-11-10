package th.ac.utc.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id; // long เป็นคลาส Wrapper จึงมีค่าเป็น null ได้
    private String name;
    private double grade;
}
