package org.example.service.impl;

import org.example.dao.ResultMapper;
import org.example.entity.Result;
import org.example.entity.Result2;
import org.example.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultMapper resultMapper;

    @Override
    public List<Result> getAllResult() {
        List<Result> result = new LinkedList<Result>();
        List<Result2> result2 = resultMapper.findAll();
        for (Result2 e : result2) {
            result.add(convertResult2ToResult(e));
        }
        return result;

    }

    @Override
    public void createResult(Result result) {

        resultMapper.save(convertResultToResult2(result));

    }

    private Vector<Integer> stringToVectorInteger(String input) {
        Vector<Integer> vector = new Vector<>();
        if (input != null && !input.isEmpty()) {
            String[] splitValues = input.split(",");
            for (String value : splitValues) {
                try {
                    vector.add(Integer.parseInt(value.trim()));
                } catch (NumberFormatException e) {
                    // 处理无法转换为整数的情况
                    System.err.println("无法将字符串转换为整数: " + value);
                }
            }
        }
        return vector;
    }

    private String vectorIntegerToString(Vector<Integer> vector) {
        // 使用逗号连接整数列表中的元素，形成一个字符串
        return vector.stream()
                .map(Object::toString) // 将整数转换为字符串
                .collect(Collectors.joining(","));
    }

    private Result2 convertResultToResult2(Result result) {
        Result2 result2 = new Result2();
        result2.setId(result.getId());
        result2.setBuffer_count(result.getBuffer_count());
        result2.setBuffer_capacity(vectorIntegerToString(result.getBuffer_capacity()));
        result2.setP1_count(result.getP1_count());
        result2.setP1_put_speed(vectorIntegerToString(result.getP1_put_speed()));
        result2.setP2_count(result.getP2_count());
        result2.setP2_get_speed(vectorIntegerToString(result.getP2_get_speed()));
        result2.setP3_count(result.getP3_count());
        result2.setP3_get_speed(vectorIntegerToString(result.getP3_get_speed()));
        result2.setP4_count(result.getP4_count());
        result2.setP4_get_speed(vectorIntegerToString(result.getP4_get_speed()));
        result2.setInputContent(vectorIntegerToString(result.getInputContent()));
        result2.setTotalRunTime(result.getTotalRunTime());
        result2.setBufferDataCount(result.getBufferDataCount());
        result2.setDataPutCount(result.getDataPutCount());
        result2.setDataGetCount(result.getDataGetCount());
        result2.setAvgDataPs(result.getAvgDataPs());
        result2.setPositive(result.getPositive());
        result2.setNegative(result.getNegative());
        result2.setZero(result.getZero());
        result2.setPositiveCon(vectorIntegerToString(result.getPositiveCon()));
        result2.setNegativeCon(vectorIntegerToString(result.getNegativeCon()));
        result2.setZeroCon(vectorIntegerToString(result.getZeroCon()));
        return result2;
    }

    private Result convertResult2ToResult(Result2 result2) {
        Result result = new Result();
        result.setId(result2.getId());
        result.setBuffer_count(result2.getBuffer_count());
        result.setBuffer_capacity(stringToVectorInteger(result2.getBuffer_capacity()));
        result.setP1_count(result2.getP1_count());
        result.setP1_put_speed(stringToVectorInteger(result2.getP1_put_speed()));
        result.setP2_count(result2.getP2_count());
        result.setP2_get_speed(stringToVectorInteger(result2.getP2_get_speed()));
        result.setP3_count(result2.getP3_count());
        result.setP3_get_speed(stringToVectorInteger(result2.getP3_get_speed()));
        result.setP4_count(result2.getP4_count());
        result.setP4_get_speed(stringToVectorInteger(result2.getP4_get_speed()));
        result.setInputContent(stringToVectorInteger(result2.getInputContent()));
        result.setTotalRunTime(result2.getTotalRunTime());
        result.setBufferDataCount(result2.getBufferDataCount());
        result.setDataPutCount(result2.getDataPutCount());
        result.setDataGetCount(result2.getDataGetCount());
        result.setAvgDataPs(result2.getAvgDataPs());
        result.setPositive(result2.getPositive());
        result.setNegative(result2.getNegative());
        result.setZero(result2.getZero());
        result.setPositiveCon(stringToVectorInteger(result2.getPositiveCon()));
        result.setNegativeCon(stringToVectorInteger(result2.getNegativeCon()));
        result.setZeroCon(stringToVectorInteger(result2.getZeroCon()));
        return result;
    }
}
