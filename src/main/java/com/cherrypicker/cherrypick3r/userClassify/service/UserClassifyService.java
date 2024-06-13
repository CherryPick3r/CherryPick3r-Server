package com.cherrypicker.cherrypick3r.userClassify.service;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassify;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassifyRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserClassifyService {
    private final UserClassifyRepository userClassifyRepository;

    private final UserRepository userRepository;

    // TODO: 유저를 받아서 유저의 태그 값을 이용해서 유저 태그 분류 테이블의 엔티티를 생성하고 값을 채워넣는 함수, n(0~1)의 값을 기준으로 이하는 0, 이상은 1로 만들어서 태그 유무를 분리한다.
    @Transactional
    public UserClassify makeUserClassifyUsingTagValues(User user, Double n) {
        Tag tag = user.getTag();

        if (tag == null) {
            return null; // TODO: TagNotFoundException
        }

        List<Double> tags = tag.getTagsByList();
        List<Long> classifys = new ArrayList<>();
        int tagsLen = tags.size();

        UserClassify userClassify = new UserClassify(user);
        user.mappingUserClassify(userClassify);

        for (int i=0;i<tagsLen;i++) {
            if (tags.get(i) <= n) {
                classifys.add(0L);
            }
            else {
                classifys.add(1L);
            }
        }

        userClassify.setShopClassifyByList(classifys);

        userClassifyRepository.save(userClassify);

        return userClassify;
    }

    // TODO: 유저를 받아서 결정치 n(0~1)에 따라서 '모든' 유저 태그 분류 테이블의 엔티티를 만드는 함수 (batchJob)
    @Transactional
    public List<UserClassify> makeAllUserClassifyUsingTagValues(Double n) {
        List<User> users = userRepository.findAll();
        List<UserClassify> userClassifies = new ArrayList<>();

        for (User user : users) {
            userClassifies.add(makeUserClassifyUsingTagValues(user, n));
        }

        return userClassifies;
    }

    // TODO: 특정 태그들에 해당하는 모든 유저를 반환하는 함수
    // 0L을 null로 바꿔서 넣는 이유: 0L을 null로 만들어서 넣으면 쿼리를 생성할 때, 해당 값은 신경쓰지 않고 넘어감
    @Transactional
    public List<User> findAllUserByClassifyTags(List<Long> tags) {
        List<User> users = new ArrayList<>();

        List<UserClassify> userClassifies = userClassifyRepository.findByUserClassifyTag1OrUserClassifyTag2OrUserClassifyTag3OrUserClassifyTag4OrUserClassifyTag5OrUserClassifyTag6OrUserClassifyTag7OrUserClassifyTag8OrUserClassifyTag9OrUserClassifyTag10OrUserClassifyTag11OrUserClassifyTag12OrUserClassifyTag13OrUserClassifyTag14OrUserClassifyTag15OrUserClassifyTag16OrUserClassifyTag17OrUserClassifyTag18OrUserClassifyTag19OrUserClassifyTag20OrUserClassifyTag21OrUserClassifyTag22OrUserClassifyTag23OrUserClassifyTag24OrUserClassifyTag25OrUserClassifyTag26OrUserClassifyTag27OrUserClassifyTag28(
                tags.get(0) == 0L ? null : tags.get(0),tags.get(1) == 0L ? null : tags.get(1),tags.get(2) == 0L ? null : tags.get(2),tags.get(3) == 0L ? null : tags.get(3),tags.get(4) == 0L ? null : tags.get(4),
                tags.get(5) == 0L ? null : tags.get(5),tags.get(6) == 0L ? null : tags.get(6),tags.get(7) == 0L ? null : tags.get(7),tags.get(8) == 0L ? null : tags.get(8),tags.get(9) == 0L ? null : tags.get(9),
                tags.get(10) == 0L ? null : tags.get(10),tags.get(11) == 0L ? null : tags.get(11),tags.get(12) == 0L ? null : tags.get(12),tags.get(13) == 0L ? null : tags.get(13),tags.get(14) == 0L ? null : tags.get(14),
                tags.get(15) == 0L ? null : tags.get(15),tags.get(16) == 0L ? null : tags.get(16),tags.get(17) == 0L ? null : tags.get(17),tags.get(18) == 0L ? null : tags.get(18),tags.get(19) == 0L ? null : tags.get(19),
                tags.get(20) == 0L ? null : tags.get(20),tags.get(21) == 0L ? null : tags.get(21),tags.get(22) == 0L ? null : tags.get(22),tags.get(23) == 0L ? null : tags.get(23),tags.get(24) == 0L ? null : tags.get(24),
                tags.get(25) == 0L ? null : tags.get(25),tags.get(26) == 0L ? null : tags.get(26),tags.get(27) == 0L ? null : tags.get(27)
        );

        for (UserClassify userClassify : userClassifies) {
            users.add(userClassify.getUser());
        }

        return users;
    }
}
