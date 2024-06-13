package com.cherrypicker.cherrypick3r.userClassify.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClassifyRepository extends JpaRepository<UserClassify, Long> {

    List<UserClassify> findByUserClassifyTag1OrUserClassifyTag2OrUserClassifyTag3OrUserClassifyTag4OrUserClassifyTag5OrUserClassifyTag6OrUserClassifyTag7OrUserClassifyTag8OrUserClassifyTag9OrUserClassifyTag10OrUserClassifyTag11OrUserClassifyTag12OrUserClassifyTag13OrUserClassifyTag14OrUserClassifyTag15OrUserClassifyTag16OrUserClassifyTag17OrUserClassifyTag18OrUserClassifyTag19OrUserClassifyTag20OrUserClassifyTag21OrUserClassifyTag22OrUserClassifyTag23OrUserClassifyTag24OrUserClassifyTag25OrUserClassifyTag26OrUserClassifyTag27OrUserClassifyTag28(
            Long tag1, Long tag2, Long tag3, Long tag4, Long tag5, Long tag6, Long tag7, Long tag8, Long tag9, Long tag10, Long tag11, Long tag12, Long tag13, Long tag14, Long tag15, Long tag16, Long tag17, Long tag18, Long tag19, Long tag20, Long tag21, Long tag22, Long tag23, Long tag24, Long tag25, Long tag26, Long tag27, Long tag28);

}
