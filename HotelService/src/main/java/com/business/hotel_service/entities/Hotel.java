package com.business.hotel_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "micro_hotel")
public class Hotel
{
    @Id
    private String  hotelId;
    private String  hotelName;
    private String  location;
    private String  about;
}
