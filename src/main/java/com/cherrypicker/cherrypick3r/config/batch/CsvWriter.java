//package com.cherrypicker.cherrypick3r.config.batch;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@RequiredArgsConstructor
//public class CsvWriter implements ItemWriter<Food> {
//
//    private final FoodRepository foodRepository;
//
//    @Override
//    public void write(List<? extends Food> list) throws Exception {
//        foodRepository.saveAll(new ArrayList<Food>(list));
//    }
//}
