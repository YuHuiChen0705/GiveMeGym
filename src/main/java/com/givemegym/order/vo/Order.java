package com.givemegym.order.vo;

import com.givemegym.mem.vo.MemberVO;
import com.givemegym.orderDetail.vo.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHOPORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOPORDER_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SHOPORDER_MEMBERID")
    private MemberVO member;

    @CreationTimestamp
    @Column(name = "SHOPORDER_CREATETIME")
    private LocalDateTime createTime;

    @Column(name = "SHOPORDER_TOTALPRICE")
    private Integer totalPrice;

    @Column(name = "SHOPORDER_STATUS")
    private Integer status;

    @Column(name = "SHOPORDER_ADDERESS", length = 100)
    private String address;

    @Column(name = "SHOPORDER_NAME", length = 20)
    private String name;

    @Column(name = "SHOPORDER_PHONE")
    private Integer phone;

    @Column(name = "SHOPORDER_NOTE", length = 100)
    private String note;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="order")
    private Set<OrderDetail> details = new HashSet<>();
}

