package com.givemegym.faqs.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "faqs", schema = "no7")
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAQS_ID", nullable = false)
    private Integer faqId;

    @Size(max = 20)
    @NotNull
    @Column(name = "FAQS_CATEGORY", nullable = false, length = 20)
    private String faqCategory;

    @Size(max = 500)
    @NotNull
    @Column(name = "FAQS_QUESTION", nullable = false, length = 500)
    private String faqQuestion;

    @Size(max = 500)
    @NotNull
    @Column(name = "FAQS_ANSWER", nullable = false, length = 500)
    private String faqAnswer;

    @Column(name = "FAQS_UPDATETIME")
    private LocalDateTime faqUpdate;

}