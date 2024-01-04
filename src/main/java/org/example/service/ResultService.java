package org.example.service;
import org.example.entity.Result;

import java.util.List;
public interface ResultService {
    List<Result> getAllResult();
    void createResult(Result result);

}
