package com.HMSync.reviews.entity;

import com.HMSync.catalog.entity.BaseEntity;
import com.HMSync.rooms.entity.Room;
import com.HMSync.security.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "reviews")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Review extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "user_id")
    private User guest;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "rating")
    private int rating;
}
