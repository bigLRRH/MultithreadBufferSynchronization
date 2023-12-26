//package org.example.controller;
//import java.util.List;
//import org.example.entity.Result;
//import org.example.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//@RestController
//@RequestMapping("/result")
//public class ResultController {
//    @Autowired
//    private ResultService resultService;
//    @GetMapping
//    public ResponseEntity<List<Result>> getAllResults() {
//        List<Result> results = resultService.getAllResults();
//        return ResponseEntity.ok(results);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Result> getResultById(@PathVariable("id") Long id) {
//        Result result = resultService.getResultById(id);
//        if (result != null) {
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PostMapping
//    public ResponseEntity<Result> createResult(@RequestBody Result result) {
//        Result createdResult = resultService.createResult(result);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdResult);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Result> updateResult(@PathVariable Long id, @RequestBody Result result) {
//        Result updatedResult = resultService.updateResult(id, result);
//        if (updatedResult != null) {
//            return ResponseEntity.ok(updatedResult);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
//        boolean deleted = resultService.deleteResult(id);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
//
