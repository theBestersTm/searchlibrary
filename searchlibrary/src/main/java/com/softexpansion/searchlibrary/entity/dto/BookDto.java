package com.softexpansion.searchlibrary.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Integer bookId;
    private String name;
    private String author;
    private String description;
    private String categoryName;

}
