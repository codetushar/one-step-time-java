package com.example.onesteptimejava.controller.algorithms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.onesteptimejava.service.DPService;
import com.example.onesteptimejava.types.BitMashSST;
import com.example.onesteptimejava.types.Graph;
import com.example.onesteptimejava.types.Matrix;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/dp")
public class DPController {
    DPService dpService = new DPService();

    @PostMapping("/lis")
    public ResponseEntity<Matrix> LIS(@RequestBody Matrix inputs,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Matrix>(HttpStatus.BAD_REQUEST);
        }
        // System.out.println(Arrays.deepToString(inputs.getMatrix().toArray()));
        return new ResponseEntity<Matrix>(dpService.LIS(inputs), null, HttpStatus.OK);
    }

    @PostMapping("/bitmask-sst")
    public ResponseEntity<Graph> smallestSufficientTeam(@RequestBody BitMashSST inputs,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Graph>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Graph>(dpService.smallestSufficientTeam(inputs.getReq_skills(), inputs.getPeople()),
                null, HttpStatus.OK);
    }
}
