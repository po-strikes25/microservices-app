package com.business.user_service.entities;

import com.sun.jdi.PrimitiveValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
