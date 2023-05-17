package com.cherrypicker.cherrypick3r.component;

import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.tag.dto.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Component
public class GameCalc {

    // 유클리디안 유사도 구하는 계산 로직
    public Double euclideanSimilarity(List<Double> listA, List<Double> listB) {
        double sumOfSquares = IntStream.range(0, listA.size())
                .mapToDouble(i -> Math.pow(listA.get(i) - listB.get(i), 2))
                .reduce(Double::sum)
                .orElse(0.0);

        return Math.sqrt(sumOfSquares);
    }

    // 두 개의 리스트를 A를 B에 가깝게 만든다. n이 0에 가까울수록 많이 가깝게 만든다.(가게를 좋아요 한 경우 계산 로직)
    public List<Double> makeSimilarly(List<Double> listA, List<Double> listB, Long n) {
        int len = listA.size();
        List<Double> ret = new ArrayList<>();

        for (int i=0;i<len;i++) {
            ret.add(listA.get(i) - ((listA.get(i) - listB.get(i)) / n)); // 값을 빼면 유사하게 만들어짐.
        }

        return ret;
    }

    // 두 개의 리스트를 A를 B와 멀어지게 만든다. n이 0에 가까울수록 많이 멀게 만든다.(가게를 싫어요 한 경우 계산 로직)
    public List<Double> makeUnsimilarly(List<Double> listA, List<Double> listB, Long n) {
        int len = listA.size();
        List<Double> ret = new ArrayList<>();

        for (int i=0;i<len;i++) {
            ret.add(listA.get(i) + ((listA.get(i) - listB.get(i)) / n)); // 값을 더하면 다르게 만들어짐.
        }

        return ret;
    }

    // 두 개의 리스트를 비교해서 점수를 계산한다.
    public Double calculateScore(List<Double> listA, List<Double> listB) {
        int len = listA.size();
        Double ret = 0D;

        for (int i=0;i<len;i++) {
            ret += listA.get(i) * (1D + (listB.get(i))); // 스코어를 계산해서 더한다.
        }

        return ret;
    }

}
