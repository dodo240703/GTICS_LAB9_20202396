package com.example.gticslab920202396.Dtos;

import com.example.gticslab920202396.Entities.Coctel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoctelResponse {

    private List<Coctel> drinks;
}
