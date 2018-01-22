package com.example.demographql.link;

import com.example.demographql.common.BaseEntity;
import com.example.demographql.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "links")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Link extends BaseEntity {
    private static final long serialVersionUID = -167152332192440001L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String description;
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
