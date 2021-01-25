package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // User : Post -> 1 : N
    @ManyToOne(fetch = FetchType.LAZY)
    // 지연 로딩 방식 : User Entity 조회할 때 Post Entity가 로딩되는게 아니라 Post Entity가 로딩되는 시점에 필요한 User데이터 로딩
    @JsonIgnore
    private User user;
}
