package com.HMSync.security.user.repository;

import com.HMSync.security.user.controller.dto.UserSearchDto;
import com.HMSync.security.user.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserSpecification {
    public static Specification<User> searchBy(String search) {
        Specification<User> firstName = ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + search.toLowerCase() + "%"));

        Specification<User> lastName = ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + search.toLowerCase() + "%"));

        Specification<User> email = ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + search.toLowerCase() + "%"));

        Specification<User> identificationNumber = ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("identificationNumber")), "%" + search.toLowerCase() + "%"));

        Specification<User> identificationDocument = ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("identificationDocument").get("name")), "%" + search.toLowerCase() + "%"));

        return Specification.where(firstName).or(lastName).or(email).or(identificationNumber).or(identificationDocument);
    }

    public static Specification<User> getPredicate(UserSearchDto criteria) {
        List<Specification<User>> specifications = new ArrayList<>();

        if (criteria.getSearch() != null && !criteria.getSearch().isBlank()) {
            specifications.add(searchBy(criteria.getSearch()));
        }

        if (specifications.isEmpty()) {
            return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
        }

        Specification<User> specification = Specification.where(specifications.get(0));

        for (int i = 1; i < specifications.size(); i++) {
            specification = specification.and(specifications.get(i));
        }

        return specification;
    }
}
