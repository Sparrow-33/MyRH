package com.example.myrh.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;

    @Column(length = 500000)
    private  byte[] imgByte;

    public Image(String originalFilename, String contentType, byte[] bytes) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id.equals(image.id) && Objects.equals(name, image.name) && Objects.equals(type, image.type) && Arrays.equals(imgByte, image.imgByte);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, type);
        result = 31 * result + Arrays.hashCode(imgByte);
        return result;
    }
}
