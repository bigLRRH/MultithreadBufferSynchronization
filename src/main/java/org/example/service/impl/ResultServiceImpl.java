//package org.example.service.impl;
//
//import org.example.entity.Result;
//import org.example.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class ResultServiceImpl implements ResultService {
//    @Autowired
//    ResultMapper resultMapper;
//    public ResultServiceImpl(ResultRepository resultRepository) {
//        this.resultRepository = resultRepository;
//    }
//
//    @Override
//    public List<Result> getAllResult() {
//        return resultRepository.findAll();
//    }
//
//    @Override
//    public Result getResultById(Long id) {
//        return resultRepository.findById(id)
//                .orElse(null); // 可以根据实际情况进行处理，比如抛出异常
//    }
//
//    @Override
//    public Result createResult(Result result) {
//        return resultRepository.save(result);
//    }
//
//    @Override
//    public Result updateResult(Long id, Result result) {
//        Result existingResult = resultRepository.findById(id)
//                .orElse(null);
//
//        if (existingResult != null) {
//            // 更新现有结果的属性
//            existingResult.setSomeProperty(result.getSomeProperty());
//            // 更新其他属性...
//
//            return resultRepository.save(existingResult);
//        } else {
//            return null; // 或者根据实际情况抛出异常或其他处理方式
//        }
//    }
//
//    @Override
//    public boolean deleteResult(Long id) {
//        resultRepository.deleteById(id);
//        return true; // 或者根据实际情况进行处理
//    }
//
//    @Override
//    public List<Result> queryByResult(Result result) {
//        // 实现根据结果查询的逻辑
//        return resultRepository.queryByResult(result);
//    }
//
//    @Override
//    public Result findByResultname(String resultname) {
//        return resultRepository.findByResultname(resultname);
//    }
//}
