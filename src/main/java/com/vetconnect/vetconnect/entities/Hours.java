package com.vetconnect.vetconnect.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class Hours {

    @ElementCollection
    private List<String> hours;
}