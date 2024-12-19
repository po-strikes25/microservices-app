package com.business.rating_service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("micro_rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating
{
    @Id
    private String  ratingId;
    private String  userId;
    private String  hotelId;
    private int     rating;
    private String  feedback;
}
