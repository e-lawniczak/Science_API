package oel.development.ScienceAPI.ICD.disorders.model;

import oel.development.ScienceAPI.ICD.symptoms.model.Keyword;
import oel.development.ScienceAPI.ICD.symptoms.model.Symptom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor@Table(
        name = "disorders",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "code")
        }
)
public class Disorder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    private String name;

    private String whoLink;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Disorder parent;

    @OneToMany(mappedBy = "parent")
    private List<Disorder> children;


    @ManyToMany
    @JoinTable(
            name = "disorder_symptom",
            joinColumns = @JoinColumn(name = "disorder_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private List<Symptom> symptoms;

    @ManyToMany
    @JoinTable(
            name = "disorder_keyword",
            joinColumns = @JoinColumn(name = "disorder_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private List<Keyword> keywords;
}
