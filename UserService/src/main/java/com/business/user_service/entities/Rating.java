package com.business.user_service.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating
{
    private String  ratingId;
    /* can't we use single-reference to user here ?? */
    private String  userId;
    private String  hotelId;
    private int     rating;
    private String  feedback;
    private Hotel   hotel;
}
